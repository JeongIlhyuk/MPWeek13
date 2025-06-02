package com.example.week13

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony

class SMSBR : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            val msg = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            val msgSender = msg[0].originatingAddress
            val msgBody = msg.joinToString(separator = "") { it.messageBody }
            val newIntent = Intent(context, MainActivity::class.java)
            newIntent.putExtra("msgSender", msgSender)
            newIntent.putExtra("msgBody", msgBody)
            newIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            val pendingIntent = PendingIntent.getActivity(
                context,
                100,
                newIntent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
            context?.let {
                val application = context.applicationContext as MyApplication
                if (application.isForeground)
                    context.startActivity(newIntent)
                else
                    makeNotification(context, msgBody, pendingIntent)
            }

//            Toast.makeText(
//                context,
//                "$msgSender : $msgBody",
//                Toast.LENGTH_SHORT
//            ).show()
        }
    }
}
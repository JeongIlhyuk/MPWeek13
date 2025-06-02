package com.example.week13

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.widget.Toast

class SMSBR : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            val msg = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            val msgSender = msg[0].originatingAddress
            val msgBody = msg.joinToString(separator = "") { it.messageBody }

            Toast.makeText(
                context,
                "$msgSender : $msgBody",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
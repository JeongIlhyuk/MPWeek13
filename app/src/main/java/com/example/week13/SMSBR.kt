import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import com.example.week13.MainActivity
import com.example.week13.makeNotification

class SMSBR : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action) {
            Intent.ACTION_BOOT_COMPLETED -> {
                // 부팅 완료 알림
            }
            Telephony.Sms.Intents.SMS_RECEIVED_ACTION -> {
                val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
                messages.forEach { sms ->
                    val sender = sms.originatingAddress
                    val body = sms.messageBody

                    // 알림 표시
                    val pendingIntent = PendingIntent.getActivity(
                        context, 0,
                        Intent(context, MainActivity::class.java),
                        PendingIntent.FLAG_IMMUTABLE
                    )
                    makeNotification(context, "From: $sender\n$body", pendingIntent)
                }
            }
        }
    }
}
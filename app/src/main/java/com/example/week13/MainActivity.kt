package com.example.week13

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.week13.ui.theme.Week13Theme

class MainActivity : ComponentActivity() {
//    val br = BatteryBR()
//    override fun onStart() {
//        super.onStart()
//        val intentFilter = IntentFilter(Intent.ACTION_POWER_CONNECTED)
//        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
//        this.registerReceiver(br, intentFilter)
//    }
//
//    override fun onStop() {
//        this.unregisterReceiver(br)
//        super.onStop()
//    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    fun handleIntent(intent: Intent) {
        val msgSender = intent.getStringExtra("msgSender")
        val msgBody = intent.getStringExtra("msgBody")

        setContent {
            Week13Theme {
                MainScreen(msgSender, msgBody)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntent(intent)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Week13Theme {
        Greeting("Android")
    }
}
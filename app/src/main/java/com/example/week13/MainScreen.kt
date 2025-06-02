package com.example.week13

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val permissions = rememberMultiplePermissionsState(
        listOf(
            android.Manifest.permission.RECEIVE_SMS,
            android.Manifest.permission.POST_NOTIFICATIONS
        )
    )
    LaunchedEffect(Unit) {
        permissions.launchMultiplePermissionRequest()
    }
//    var msg by remember {
//        mutableStateOf("")
//    }
//    MyBR(Intent.ACTION_POWER_CONNECTED) {
//        msg = "전원연결"
//    }
//
//    MyBR(Intent.ACTION_POWER_DISCONNECTED) {
//        msg = "전원연결해제"
//    }
//
//    Column {
//        Text(text = msg)
//    }
}
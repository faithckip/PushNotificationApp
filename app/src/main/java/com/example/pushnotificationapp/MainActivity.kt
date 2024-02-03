package com.example.pushnotificationapp

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.pushnotificationapp.ui.Push.ChatScreen
import com.example.pushnotificationapp.ui.Push.ChatViewModel
import com.example.pushnotificationapp.ui.Push.EnterTokenDialog
import com.example.pushnotificationapp.ui.theme.PushNotificationAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel: ChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PushNotificationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val state = viewModel.state
                    if (state.isEnteringToken){
                        EnterTokenDialog(
                            token = state.remoteToken,
                            onTokenChange = viewModel::onRemoteTokenChange,
                            onSubmit = viewModel::onSubmitRemoteToken
                        )
                    } else {
                        ChatScreen(
                            messageText = state.messageText,
                            onMessageSend = { viewModel.sendMessage(isBroadcast = false) },
                            onMessageBroadcast = { viewModel.sendMessage(isBroadcast = true)},
                            onMessageChange = viewModel::onMessageChange)

                        }
                }
            }
        }
    }
}
/*
private fun requestNotificationPermission(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
        val hasPermission = ContextCompat.checkSelfPermission(
            /* context = */ this,
            /* permission = */ Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasPermission){
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0
            )

        }
    }
}
*/

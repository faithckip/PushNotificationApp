package com.example.pushnotificationapp.ui.Push

data class ChatState(
    val isEnteringToken: Boolean = true,
    val remoteToken: String = "",
    val messageText: String = "  "
)

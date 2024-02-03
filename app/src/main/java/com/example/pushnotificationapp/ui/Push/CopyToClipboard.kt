package com.example.pushnotificationapp.ui.Push

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CopyToClipboard() {
    
    val clipboardManager = LocalClipboardManager.current
    val text = remember{ mutableStateOf("") }
    
    Column {
        TextField(
            value = text.value , 
            onValueChange = {text.value = it},
            label = { Text(text = "Text to copy")})
        
        Button(onClick = { clipboardManager.setText(AnnotatedString(text.value)) }) {
            Text(text = "Copy to clipboard")
        }
    }
}
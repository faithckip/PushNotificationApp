package com.example.pushnotificationapp.ui.Push

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalClipboardManager

@Composable
fun PasteFromClipboard() {

    val clipboardManager = LocalClipboardManager.current
    val text = remember { mutableStateOf("") }

    Column {
        Text(text = text.value)
        Button(onClick = {
            val clipData =clipboardManager.getText()   //to get gets the current contents of the clipdoard
            if (clipData != null){
                text.value = clipData.text
            }}){
            Text(text = "Paste from clipboard")    //displays current value of the text
        }

    }

}
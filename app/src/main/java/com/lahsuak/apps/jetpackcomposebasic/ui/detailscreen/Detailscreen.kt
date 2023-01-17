package com.lahsuak.apps.jetpackcomposebasic.ui.detailscreen

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.lahsuak.apps.jetpackcomposebasic.ui.openTab

@Composable
fun DetailScreen(text: String) {
    val context = LocalContext.current
    Text(text = text, Modifier.clickable {
        openTab(context, text)
    })
}
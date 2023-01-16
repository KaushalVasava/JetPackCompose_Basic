package com.lahsuak.apps.jetpackcomposebasic.ui.elements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lahsuak.apps.jetpackcomposebasic.ui.theme.JetPackComposeBasicTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextUI(
    labelMsg: String,
    modifier: Modifier = Modifier
) {
    var editTextState by rememberSaveable {
        mutableStateOf("")
    }
    TextField(
        value = editTextState,
        modifier = modifier,
        label = {
            Text(labelMsg)
        },
        onValueChange = {
            editTextState = it
        },
        singleLine = true
    )
}

@Preview
@Composable
fun EditTextPreview() {
    JetPackComposeBasicTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            EditTextUI("Enter your name")
        }
    }
}

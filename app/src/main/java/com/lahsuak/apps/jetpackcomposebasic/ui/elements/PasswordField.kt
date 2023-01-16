package com.lahsuak.apps.jetpackcomposebasic.ui.elements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.lahsuak.apps.jetpackcomposebasic.ui.theme.JetPackComposeBasicTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldUI(
    labelMsg: String,
    modifier: Modifier = Modifier
) {
    var editTextState by rememberSaveable { mutableStateOf("") }
    // Creating a variable to store toggle state
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    TextField(
        value = editTextState,
        modifier = modifier,
        label = {
            Text(labelMsg)
        },
        onValueChange = {
            editTextState = it
        },
        visualTransformation =
        if (passwordVisible)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Add
            else Icons.Filled.Close
            // Localized description for accessibility services
            val description = if (passwordVisible) "Hide password" else "Show password"
            // Toggle button to hide or display password
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, description)
            }
        },
        singleLine = true
    )
}

@Preview
@Composable
fun PasswordFieldPreview() {
    JetPackComposeBasicTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            PasswordFieldUI("Enter your password")
        }
    }
}

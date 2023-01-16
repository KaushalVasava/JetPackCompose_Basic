package com.lahsuak.apps.jetpackcomposebasic.ui.elements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lahsuak.apps.jetpackcomposebasic.ui.theme.JetPackComposeBasicTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(placeHolderMsg: String, modifier: Modifier) {
    var editTextState by rememberSaveable {
        mutableStateOf("")
    }
    TextField(
        value = editTextState,
        modifier = modifier,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        placeholder = {
            Text(placeHolderMsg)
        },
        onValueChange = {
            editTextState = it
        },
        singleLine = true
    )
}

@Preview
@Composable
fun SearchPreview() {
    JetPackComposeBasicTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Search("Enter your name", Modifier)
        }
    }
}

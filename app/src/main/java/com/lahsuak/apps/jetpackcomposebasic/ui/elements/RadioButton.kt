package com.lahsuak.apps.jetpackcomposebasic.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lahsuak.apps.jetpackcomposebasic.ui.theme.JetPackComposeBasicTheme

@Composable
fun RadioButtonUI() {
    val radioOptions = listOf("DSA", "Java", "Kotlin")
    val (selectedOption, onOptionSelected) = rememberSaveable() { mutableStateOf(radioOptions[2]) }
    Column(modifier = Modifier.padding(8.dp)) {
        Row {
            radioOptions.forEach { text ->
                RadioButton(
                    selected = text == selectedOption,
                    onClick = { onOptionSelected(text) },
                )
                Text(text = text, modifier = Modifier.align(Alignment.CenterVertically))
            }
        }
    }
}

@Preview
@Composable
fun RadioPreview() {
    JetPackComposeBasicTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RadioButtonUI()
        }
    }
}
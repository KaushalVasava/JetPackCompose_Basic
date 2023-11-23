package com.lahsuak.apps.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lahsuak.apps.jetpackcomposebasic.ui.theme.JetPackComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Kaushal")
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name)
        }
    }
}

/**
 * Composable functions :
A composable function is a regular function annotated with @Composable.
This enables your function to call other @Composable functions within it.
You can see how the Greeting function is marked as @Composable.
This function will produce a piece of UI hierarchy displaying the given input,
String. Text is a composable function provided by the library.
 **/

/**
 * 1. Column is Vertical linear layout of view system
 * 2. Row is Horizontal linear layout of view system
 * 3. Box is FrameLayout of view system
 */

/**
 * Button is a composable provided by the material3 package
which takes a composable as the last argument.
Since trailing lambdas can be moved outside of the parentheses,
you can add any content to the button as a child. For example, a Text
 */

@Composable
fun Greeting(name: String) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hello,")
                Text(text = name)
            }
            ElevatedButton(onClick = { }) {
                Text(text = "Show more")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeBasicTheme {
        MyApp()
    }
}
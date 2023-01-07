package com.lahsuak.apps.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.lahsuak.apps.jetpackcomposebasic.ui.screen.OnBoarding
import com.lahsuak.apps.jetpackcomposebasic.ui.theme.JetPackComposeBasicTheme

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     OnBoarding(modifier = Modifier)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
@ExperimentalPagerApi
fun DefaultPreview() {
    JetPackComposeBasicTheme {
       OnBoarding(modifier = Modifier)
    }
}
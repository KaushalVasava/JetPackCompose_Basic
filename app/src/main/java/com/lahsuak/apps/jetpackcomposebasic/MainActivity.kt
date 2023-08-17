package com.lahsuak.apps.jetpackcomposebasic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.lahsuak.apps.jetpackcomposebasic.ui.navhost.AppNavHost
import com.lahsuak.apps.jetpackcomposebasic.ui.screen.HomeScreen
import com.lahsuak.apps.jetpackcomposebasic.ui.theme.JetPackComposeBasicTheme
import com.lahsuak.apps.jetpackcomposebasic.ui.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost(navController = rememberNavController(), viewModel = viewModel)
                }
            }
        }
    }
}
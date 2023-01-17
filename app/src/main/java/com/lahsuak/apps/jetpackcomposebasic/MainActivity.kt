package com.lahsuak.apps.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lahsuak.apps.jetpackcomposebasic.model.News
import com.lahsuak.apps.jetpackcomposebasic.ui.NewsItem
import com.lahsuak.apps.jetpackcomposebasic.ui.elements.*
import com.lahsuak.apps.jetpackcomposebasic.ui.theme.JetPackComposeBasicTheme
import com.lahsuak.apps.jetpackcomposebasic.ui.viewmodel.NewsViewModel

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
                    val newsViewModel: NewsViewModel = viewModel()
                    newsViewModel.getNews("general")
                    getNewsData(modifier = Modifier.fillMaxSize(), newsViewModel)
//                    Column(Modifier.padding(vertical = 16.dp, horizontal = 8.dp)) {
//                        RadioButtonUI()
//                        CheckBoxUI("Accept term and condition")
//                        EditTextUI("Enter your name", modifier = Modifier.fillMaxWidth())
//                        PasswordFieldUI("Enter your password", modifier = Modifier.fillMaxWidth())
//                        Search(placeHolderMsg = "Search", modifier = Modifier.fillMaxWidth())
//                        SnackBarUI("Hello it's me snackbar")
//                    }
                }
            }
        }
    }
}

@Composable
fun getList(): List<News> {
    val list = mutableListOf<News>()
    for (i in 0..10) {
        list.add(
            News(
                "Kaushal",
                "Ness",
                "https://pixabay.com/get/gc5bde75f8a92a997aa842681d52d37e41990f5e639497bad55c1cf9921835528340e1269788a027624b201d17734fb431c5269478e54aece4e65f7581452fe98_640.jpg",
                "https://pixabay.com/get/gc5bde75f8a92a997aa842681d52d37e41990f5e639497bad55c1cf9921835528340e1269788a027624b201d17734fb431c5269478e54aece4e65f7581452fe98_640.jpg",
            )
        )
    }
    return list
}

@Composable
fun getNewsData(
    modifier: Modifier,
    newsViewModel: NewsViewModel
) {
    val newsList by newsViewModel.newsFlow.collectAsState()
//    val d = getList()
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = newsList) { news ->
            NewsItem(news = news)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeBasicTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RadioButtonUI()
            CheckBoxUI("Accept term and condition")
            EditTextUI("Enter your name", modifier = Modifier.fillMaxWidth())
            PasswordFieldUI("Enter your password", modifier = Modifier.fillMaxWidth())
        }
    }
}
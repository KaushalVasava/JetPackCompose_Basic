package com.lahsuak.apps.jetpackcomposebasic.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lahsuak.apps.jetpackcomposebasic.model.News
import com.lahsuak.apps.jetpackcomposebasic.ui.NewsItem
import com.lahsuak.apps.jetpackcomposebasic.ui.viewmodel.NewsViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    newsViewModel: NewsViewModel
) {

    val newsList by newsViewModel.newsFlow.collectAsState()
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = newsList) { news ->
            NewsItem(
                news = news,
            ) {
                navController.currentBackStackEntry?.savedStateHandle?.set("news", news)
                navController.navigate("details")
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
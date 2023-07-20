package com.lahsuak.apps.jetpackcomposebasic.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lahsuak.apps.jetpackcomposebasic.model.News
import com.lahsuak.apps.jetpackcomposebasic.ui.components.ChipGroup
import com.lahsuak.apps.jetpackcomposebasic.ui.components.NewsItem
import com.lahsuak.apps.jetpackcomposebasic.ui.components.model.Category
import com.lahsuak.apps.jetpackcomposebasic.ui.components.model.CategoryType
import com.lahsuak.apps.jetpackcomposebasic.ui.viewmodel.NewsViewModel

@Composable
fun HomeScreen(navController: (News) -> Unit) {
    val newsViewModel: NewsViewModel = viewModel()
    val newsList by newsViewModel.newsFlow.collectAsState()
    val categories = listOf(
        Category(0, CategoryType.GENERAL.name.lowercase()),
        Category(1, CategoryType.ENTERTAINMENT.name.lowercase()),
        Category(2, CategoryType.SPORTS.name.lowercase())
    )
    var selectedItem by rememberSaveable {
        mutableStateOf(categories[0]) // initially, first item is selected
    }
    Box(
        Modifier
            .fillMaxSize()
    ) {
        Column {
            ChipGroup(
                categories,
                selectedItem
            ) {
                selectedItem = it
                newsViewModel.getNews(it.name)
            }
            LazyColumn(modifier = Modifier.padding(horizontal = 8.dp)) {
                items(items = newsList) { news ->
                    NewsItem(
                        news = news,
                    ) {
                        navController(news)
                    }
                }
            }
        }
    }
}
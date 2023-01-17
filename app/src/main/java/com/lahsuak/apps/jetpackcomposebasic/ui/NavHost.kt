package com.lahsuak.apps.jetpackcomposebasic.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lahsuak.apps.jetpackcomposebasic.model.News
import com.lahsuak.apps.jetpackcomposebasic.ui.detailscreen.DetailScreen
import com.lahsuak.apps.jetpackcomposebasic.ui.home.HomeScreen
import com.lahsuak.apps.jetpackcomposebasic.ui.viewmodel.NewsViewModel

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavigationItem.Home.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route) {
            val newsViewModel: NewsViewModel = viewModel()
            newsViewModel.getNews("general")
            HomeScreen(
                navController, newsViewModel
            )
        }
        composable(NavigationItem.Details.route) {
            val news =
                navController.previousBackStackEntry?.savedStateHandle?.get<News>("news")
            DetailScreen(text = news?.url?:"")
        }
    }
}
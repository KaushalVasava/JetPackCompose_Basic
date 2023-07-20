package com.lahsuak.apps.jetpackcomposebasic.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lahsuak.apps.jetpackcomposebasic.model.News
import com.lahsuak.apps.jetpackcomposebasic.ui.screen.detailscreen.DetailScreen
import com.lahsuak.apps.jetpackcomposebasic.ui.screen.home.HomeScreen

private const val NEWS_ARG = "news"
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
            HomeScreen {
                navController.currentBackStackEntry?.savedStateHandle?.set(NEWS_ARG, it)
                navController.navigate(State.DETAILS.name)
            }
        }
        composable(NavigationItem.Details.route) {
            val news =
                navController.previousBackStackEntry?.savedStateHandle?.get<News>(NEWS_ARG)
            news?.let {
                DetailScreen(it,navController)
            }
        }
    }
}
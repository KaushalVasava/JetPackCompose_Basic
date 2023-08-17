package com.lahsuak.apps.jetpackcomposebasic.ui.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.lahsuak.apps.jetpackcomposebasic.ui.navigation.NavigationItem
import com.lahsuak.apps.jetpackcomposebasic.ui.screen.HomeScreen
import com.lahsuak.apps.jetpackcomposebasic.ui.screen.ViewScreen
import com.lahsuak.apps.jetpackcomposebasic.ui.viewmodel.MainViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MainViewModel,
    startDestination: String = NavigationItem.Home.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(viewModel, navController)
        }
        composable("${NavigationItem.ViewWallpaper.route}/{url}",
            arguments = listOf(navArgument("url") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            val url = navBackStackEntry.arguments?.getString("url")
            url?.let {
                ViewScreen(it, navController)
            }
        }
    }
}
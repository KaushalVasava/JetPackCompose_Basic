package com.lahsuak.apps.jetpackcomposebasic.ui.navigation.navhost

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lahsuak.apps.jetpackcomposebasic.ui.navigation.NavigationItem
import com.lahsuak.apps.jetpackcomposebasic.ui.screen.AnimateContent
import com.lahsuak.apps.jetpackcomposebasic.ui.screen.AnimateStateValue
import com.lahsuak.apps.jetpackcomposebasic.ui.screen.AnimateViewVisibility
import com.lahsuak.apps.jetpackcomposebasic.ui.screen.HomeScreen
import com.lahsuak.apps.jetpackcomposebasic.ui.screen.ImageBorderAnimation
import com.lahsuak.apps.jetpackcomposebasic.ui.screen.RepeatAnimationInfinite

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(400)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(400)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(400)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(400)
            )
        }
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.AnimateState.route) {
            AnimateStateValue()
        }
        composable(NavigationItem.AnimateContent.route) {
            AnimateContent()
        }
        composable(NavigationItem.AnimateVisibility.route) {
            AnimateViewVisibility()
        }
        composable(NavigationItem.InfiniteAnimation.route) {
            RepeatAnimationInfinite()
        }
        composable(NavigationItem.ImageBorderAnimation.route) {
            ImageBorderAnimation()
        }
    }
}
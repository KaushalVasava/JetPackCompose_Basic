package com.lahsuak.apps.jetpackcomposebasic.ui.navigation

enum class Screen {
    Home,
    AnimateVisibility,
    AnimateContent,
    AnimateState,
    InfiniteAnimation,
    ImageBorderAnimation,
}
sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(Screen.Home.name)
    object AnimateVisibility : NavigationItem(Screen.AnimateVisibility.name)
    object AnimateContent : NavigationItem(Screen.AnimateContent.name)
    object AnimateState : NavigationItem(Screen.AnimateState.name)
    object InfiniteAnimation : NavigationItem(Screen.InfiniteAnimation.name)
    object ImageBorderAnimation : NavigationItem(Screen.ImageBorderAnimation.name)
}
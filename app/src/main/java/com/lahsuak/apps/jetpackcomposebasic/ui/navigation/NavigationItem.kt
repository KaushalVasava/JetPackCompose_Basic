package com.lahsuak.apps.jetpackcomposebasic.ui.navigation

enum class Screen {
    HOME,
    VIEW_WALLPAPER
}

sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(Screen.HOME.name)
    object ViewWallpaper : NavigationItem(Screen.VIEW_WALLPAPER.name)
}
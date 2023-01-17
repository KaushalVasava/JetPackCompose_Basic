package com.lahsuak.apps.jetpackcomposebasic.ui

sealed class NavigationItem(val route: String) {
    object Home : NavigationItem("home")
    object Details : NavigationItem("details")
}
package com.lahsuak.apps.jetpackcomposebasic.ui.navigation

enum class State{
    HOME,
    DETAILS
}
sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(State.HOME.name)
    object Details : NavigationItem(State.DETAILS.name)
}
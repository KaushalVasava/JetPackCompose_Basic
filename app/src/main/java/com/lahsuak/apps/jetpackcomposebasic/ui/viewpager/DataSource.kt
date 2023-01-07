package com.lahsuak.apps.jetpackcomposebasic.ui.viewpager

import androidx.annotation.DrawableRes
import com.lahsuak.apps.jetpackcomposebasic.R

data class Pager(
    @DrawableRes val image: Int,
    val description: String
)

val dataList = listOf(
    Pager(R.drawable.ic_music, "Music"),
    Pager(R.drawable.ic_notifications, "Notification"),
    Pager(R.drawable.ic_gesture, "Gestures")
)
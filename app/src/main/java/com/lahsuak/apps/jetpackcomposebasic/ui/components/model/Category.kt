package com.lahsuak.apps.jetpackcomposebasic.ui.components.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val pos: Int,
    val name: String,
) : Parcelable
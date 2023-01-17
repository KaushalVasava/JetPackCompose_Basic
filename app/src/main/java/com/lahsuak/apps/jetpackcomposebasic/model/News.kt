package com.lahsuak.apps.jetpackcomposebasic.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val description: String,
    val title: String,
    val url: String,
    val urlToImage: String,
) : Parcelable

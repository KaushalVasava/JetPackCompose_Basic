package com.lahsuak.apps.jetpackcomposebasic.model

import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("urls")
    val urls: UrlModel,
)

package com.lahsuak.apps.jetpackcomposebasic.model

data class NewsParentModel(
    val status: String,
    val totalResults: Int,
    val articles: List<News>
)
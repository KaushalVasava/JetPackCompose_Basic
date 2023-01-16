package com.lahsuak.apps.jetpackcomposebasic.repo

import com.lahsuak.apps.jetpackcomposebasic.api.ApiClient
import com.lahsuak.apps.jetpackcomposebasic.api.NewApi
import com.lahsuak.apps.jetpackcomposebasic.model.News
import com.lahsuak.apps.jetpackcomposebasic.model.NewsParentModel

class NewsRepository(private val apiInterface: NewApi= ApiClient.apiInterface) {
    suspend fun getNews(category: String): NewsParentModel {
        return apiInterface.getNews(
//            category
        )
    }
}
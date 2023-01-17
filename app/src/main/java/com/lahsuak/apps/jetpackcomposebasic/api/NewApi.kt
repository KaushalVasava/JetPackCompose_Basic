package com.lahsuak.apps.jetpackcomposebasic.api

import com.lahsuak.apps.jetpackcomposebasic.model.News
import com.lahsuak.apps.jetpackcomposebasic.model.NewsParentModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface NewApi {
    companion object {
        const val BASE_URL = "https://saurav.tech"//NewsAPI/top-headlines/category/general/in.json"
    }

    @GET("/NewsAPI/top-headlines/category/general/in.json")
    suspend fun getNews(
//        @Path("category")
//        category: String
    ): NewsParentModel

    @GET("/NewsAPI/top-headlines/category/general/in.json")
    suspend fun getNews2(
//        @Path("category")
//        category: String
    ): Response<NewsParentModel>
}
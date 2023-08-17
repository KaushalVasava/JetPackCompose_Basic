package com.lahsuak.apps.jetpackcomposebasic.network

import com.lahsuak.apps.jetpackcomposebasic.util.AppConstants.API_KEY
import com.lahsuak.apps.jetpackcomposebasic.model.ImageModel
import com.lahsuak.apps.jetpackcomposebasic.model.SearchModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "Accept: application/json",
        "Authorization: Client-ID $API_KEY"
    )
    @GET("/photos")
    suspend fun getImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<List<ImageModel>>

    @Headers("Authorization: Client-ID $API_KEY")
    @GET("/search/photos")
    suspend fun getSearchImages(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<SearchModel>

}
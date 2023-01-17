package com.lahsuak.apps.jetpackcomposebasic.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val apiInterface: NewApi by lazy {
        Retrofit.Builder()
            .baseUrl(NewApi.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(NewApi::class.java)
    }
}
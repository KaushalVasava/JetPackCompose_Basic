package com.lahsuak.apps.jetpackcomposebasic

import com.lahsuak.apps.jetpackcomposebasic.api.NewApi
import com.lahsuak.apps.jetpackcomposebasic.ui.Helper
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiTest {

    lateinit var mockWebServer: MockWebServer
    lateinit var newApi: NewApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        newApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewApi::class.java)
    }

    @Test
    fun testGetNews_ReturnEmptyResponse() = runBlocking {
      val mockResponse = MockResponse()
        mockResponse.setBody("{}")
        mockWebServer.enqueue(mockResponse)

        val response = newApi.getNews()
        mockWebServer.takeRequest()
        Assert.assertEquals(null, response.articles)
    }

    @Test
    fun testGetNews_returnNews() = runBlocking {
        val mockResponse = MockResponse()
        val content = Helper.readFileResource("/test.json")
        mockResponse.setResponseCode(200)
        mockResponse.setBody(content)
        mockWebServer.enqueue(mockResponse)

        val response = newApi.getNews()
        mockWebServer.takeRequest()
        Assert.assertEquals(true, response.articles.isNotEmpty())
        Assert.assertEquals(2, response.articles.size)
    }

    @Test
    fun testGetNews_returnError() = runBlocking {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(404)
        mockResponse.setBody("Something went wrong!")
        mockWebServer.enqueue(mockResponse)

        val response = newApi.getNews2()
        mockWebServer.takeRequest()
        Assert.assertEquals(true, response.isSuccessful)
        Assert.assertEquals(404, response.code())
    }


    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}

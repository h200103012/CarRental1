package com.example.carrental

import com.example.carrental.api.NewsApiJSON
import retrofit2.http.GET

interface APIRequest {
    @GET("/v2/everything?q=Car&from=2022-12-08&sortBy=popularity&apiKey=7ae0805515674f2692687dd01f0c5b8d")

    suspend fun getNews() : NewsApiJSON
}
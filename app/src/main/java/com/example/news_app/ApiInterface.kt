package com.example.news_app

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("v2/top-headlines?apiKey=1625a3b2acf242b4bcdb317f7e15c1a2&sources=google-news-in")
    fun getData():Call<DataClass>

}
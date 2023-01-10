package com.example.news_app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {

    private val retrofit = Retrofit.Builder().baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiInterface = retrofit.create(ApiInterface::class.java)
}
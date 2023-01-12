package com.example.news_app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("v2/top-headlines?apiKey=1625a3b2acf242b4bcdb317f7e15c1a2&category=technology&language=en")
    fun getTech(@Query("page") pagenumber : Int):Call<News>

    @GET("v2/top-headlines?apiKey=1625a3b2acf242b4bcdb317f7e15c1a2&language=en")
    fun getIndia(@Query("country") country : String , @Query("page") pagenumber : Int):Call<News>

    @GET("v2/top-headlines?apiKey=1625a3b2acf242b4bcdb317f7e15c1a2&language=en&pageSize=30")
    fun getNews( @Query("page") pagenumber : Int):Call<News>

    @GET("v2/top-headlines?apiKey=1625a3b2acf242b4bcdb317f7e15c1a2&category=business&language=en")
    fun getBusiness( @Query("page") pagenumber : Int):Call<News>

    @GET("v2/top-headlines?apiKey=1625a3b2acf242b4bcdb317f7e15c1a2&category=sports&language=en")
    fun getSports( @Query("page") pagenumber : Int):Call<News>

    @GET("v2/top-headlines?apiKey=1625a3b2acf242b4bcdb317f7e15c1a2&category=science&language=en")
    fun getScience( @Query("page") pagenumber : Int):Call<News>


}
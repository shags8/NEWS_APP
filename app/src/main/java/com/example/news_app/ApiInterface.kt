package com.example.news_app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
//@Query("country") country : String
interface ApiInterface {
    @GET("v2/top-headlines?apiKey=1625a3b2acf242b4bcdb317f7e15c1a2&category=technology")
    fun getData(@Query("page") pagenumber : Int):Call<News>

}
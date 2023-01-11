package com.example.news_app


data class News(
    val totalResults : Int ,
    val articles : ArrayList<DataClass>)

data class DataClass(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
)
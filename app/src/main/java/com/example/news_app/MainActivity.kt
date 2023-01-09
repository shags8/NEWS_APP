package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var newrecyclerview :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newrecyclerview = findViewById(R.id.Recyclerview)
        newrecyclerview.layoutManager = LinearLayoutManager(this)
        newrecyclerview.hasFixedSize()







    }
}
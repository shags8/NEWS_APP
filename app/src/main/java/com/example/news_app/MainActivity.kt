package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.Tab
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var newrecyclerview : RecyclerView
    lateinit var adapter : ADPATER
    var pagenumber = 1
    var totalresults = -1
    var articles = mutableListOf<DataClass>()
    var india = findViewById<TextView>(R.id.India)
    var home = findViewById<TextView>(R.id.home)
    var tech = findViewById<TextView>(R.id.Tech)
    var sports = findViewById<TextView>(R.id.Sports)
    var buisness = findViewById<TextView>(R.id.Buisness)
    var science = findViewById<TextView>(R.id.Science)
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(news_1())
        tabLayout = findViewById(R.id.taskbar)
        tabLayout.addOnTabSelectedListener(new TabLayout.OnSelectedListener)
        india.setOnClickListener{
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame,fragment)
        fragmentTransaction.commit()
    }
    private fun getData() {
        RetrofitApi.apiInterface.getData(pagenumber).enqueue(object : Callback<News?> {
            override fun onResponse(
                call: Call<News?>,
                response: Response<News?>
            ) {
                val news = response.body()
                if(news!=null)
                {
                    totalresults = news.totalResults
                    articles.addAll(news.articles)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
            }
        })
    }
}
package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        replaceFragment(INDIA())
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame,fragment)
        fragmentTransaction.commit()
    }
   /* private fun getData() {
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
    }*/
}
package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var newrecyclerview : RecyclerView
    lateinit var adapter : ADPATER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()


    }

   /* private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame,fragment)
        fragmentTransaction.commit()
    } */
    private fun getData() {
        RetrofitApi.apiInterface.getData().enqueue(object : Callback<News?> {
            override fun onResponse(
                call: Call<News?>,
                response: Response<News?>
            ) {
                val news = response.body()
                if(news!=null)
                {
                    newrecyclerview = findViewById(R.id.Recyclerview)
                    adapter = ADPATER(this@MainActivity , news.articles )
                    newrecyclerview.adapter = adapter
                    newrecyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
            }
        })
    }
}
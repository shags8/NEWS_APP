package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        // replaceFragment(INDIA())
        val viewPager: ViewPager2 = findViewById(R.id.frame)
        val tabLayout: TabLayout = findViewById(R.id.taskbar)
        viewPager.adapter = FragmentAdpater(this)
       TabLayoutMediator(tabLayout, viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            val tabNames = listOf("HOME", "INDIA", "TECH", "SPORTS","BUSINESS","SCIENCE")
            tab.text = tabNames[position]
        }).attach()

    }

   /* private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame,fragment)
        fragmentTransaction.commit()
    }*/
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
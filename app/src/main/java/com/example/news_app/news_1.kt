package com.example.news_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class news_1 : Fragment() {

    lateinit var newrecyclerview : RecyclerView
    lateinit var adapter : ADPATER
    var pagenumber = 1
    var totalresults = -1
    var articles = mutableListOf<DataClass>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newrecyclerview = view.findViewById(R.id.Recyclerview)
        adapter = ADPATER(this@news_1 , articles as ArrayList<DataClass>)
        newrecyclerview.adapter = adapter
        newrecyclerview.layoutManager = LinearLayoutManager(context)
        getData()



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
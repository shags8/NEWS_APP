package com.example.news_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ADPATER( val newslist: ArrayList<DataClass>) : RecyclerView.Adapter<ADPATER.Viewholder>(){

    override fun getItemCount(): Int {
        return  newslist.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list2,parent,false)
        return Viewholder(itemView)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val currentItem = newslist[position]
        holder.headingview.text = currentItem.title
      //  Glide.with(context).load(currentItem.urlToImage).into(holder.image)
    }
    class Viewholder(item : View) : RecyclerView.ViewHolder(item)
    {
        val image :ShapeableImageView = itemView.findViewById(R.id.list_item)
        val headingview : TextView = itemView.findViewById(R.id.textView)
    }

}
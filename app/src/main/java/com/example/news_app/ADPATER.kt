package com.example.news_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.google.android.material.imageview.ShapeableImageView

class ADPATER(private val newslist : ArrayList<News>) : RecyclerView.Adapter<ADPATER.Viewholder>(){

    override fun getItemCount(): Int {
        return  newslist.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false)
        return Viewholder(itemView)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val currentItem = newslist[position]
        holder.image.setImageResource(currentItem.displaypicture)
        holder.headingview.text = currentItem.heading
    }
    class Viewholder(item : View) : RecyclerView.ViewHolder(item)
    {
        val image :ShapeableImageView = itemView.findViewById(R.id.list_item)
        val headingview : TextView = itemView.findViewById(R.id.textView)
    }

}
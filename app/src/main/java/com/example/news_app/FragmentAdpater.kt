package com.example.news_app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdpater(fm: FragmentActivity):FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
       return 6
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> news_1()
            1 -> INDIA()
            2-> Tech()
            3-> Sports()
            4-> Business()
            5-> Science()
            else -> news_1()
        }
    }

}
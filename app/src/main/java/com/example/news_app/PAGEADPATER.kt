package com.example.news_app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PAGEADPATER(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 6
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return news_1()

            else -> return news_1()
        }

    }
}
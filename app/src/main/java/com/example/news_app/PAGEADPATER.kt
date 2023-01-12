package com.example.news_app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class PAGEADPATER(fm : FragmentManager , lifecycle : Lifecycle) : FragmentStateAdapter(fm , lifecycle) {
    override fun getItemCount(): Int {
       return 6
    }

    override fun createFragment(position: Int): Fragment {
         when(position){
            0-> return news_1()
            1->  return INDIA()
            else-> return news_1()
        }
    }

}
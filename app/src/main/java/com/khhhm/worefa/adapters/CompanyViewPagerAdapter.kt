package com.khhhm.worefa.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.khhhm.worefa.CompanyServicesFragment
import com.khhhm.worefa.InfoDeskFragment
import com.khhhm.worefa.NewsFeedFragment

class CompanyViewPagerAdapter(val fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
       when(position){
           0 -> return CompanyServicesFragment()
           1 -> return NewsFeedFragment()
           2 -> return InfoDeskFragment()
       }
        return CompanyServicesFragment()
    }

    override fun getCount(): Int {
     return  3
    }
}
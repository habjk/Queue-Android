package com.khhhm.worefa

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.khhhm.worefa.adapters.MainViewPagerAdapter
import com.khhhm.worefa.adapters.dummy.DummyContent
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*




class HomeFragment : Fragment(){

   // private lateinit var viewPager: ViewPager
    private lateinit var mainPageAdapter:MainViewPagerAdapter
   private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val fragmentManager = super.getFragmentManager()
        if (fragmentManager != null) {
            val adapter:FragmentPagerItemAdapter= FragmentPagerItemAdapter(fragmentManager, FragmentPagerItems.with(this.context)
                .add("home",CompanyFragment::class.java)
                .add("Companys",AppointFragment::class.java)
                .add("About ",CompanyFragment::class.java)
                .add("Settings",AppointFragment::class.java).create())
           val viewPager:ViewPager=view.findViewById(R.id.main_view_pager) as ViewPager
            viewPager.adapter=adapter
            val smartTabLayout=view.findViewById(R.id.viewpagertab) as SmartTabLayout
            smartTabLayout.setViewPager(viewPager)

           // view.main_view_pager.adapter = MainViewPagerAdapter(fragmentManager, this.context)
           // view.home_tab_menu.setupWithViewPager(view.main_view_pager)
        }

      //  view.home_tab_menu.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"))
      //  view.home_tab_menu.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"))

        return view
    }

}
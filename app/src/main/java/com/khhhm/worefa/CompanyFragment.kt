package com.khhhm.worefa

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.khhhm.worefa.adapters.MainViewPagerAdapter
import com.khhhm.worefa.adapters.MyAppointRecyclerViewAdapter
import com.khhhm.worefa.adapters.MyServicesRecyclerViewAdapter
import com.khhhm.worefa.viewmodels.CompanyViewModel
import kotlinx.android.synthetic.main.fragment_company.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_home.view.home_tab_menu

class CompanyFragment : Fragment() {
    lateinit var companyViewModel: CompanyViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        companyViewModel=ViewModelProviders.of(this).get(CompanyViewModel::class.java)
        companyViewModel.getCompanys();
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_company,container,false)
    /*    val fragmentManager=super.getFragmentManager()
        if(fragmentManager!=null) {
            view.company_view_pager.adapter = MainViewPagerAdapter(fragmentManager,this.context)
            view.home_tab_menu.setupWithViewPager(view.main_view_pager)
        }

        view.home_tab_menu.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"))
        view.home_tab_menu.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"))
*/
        this.companyViewModel.reload()

        return view
    }


}
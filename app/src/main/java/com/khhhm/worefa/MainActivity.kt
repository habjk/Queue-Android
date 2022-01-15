package com.khhhm.worefa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khhhm.worefa.AppointFragment.OnListFragmentInteractionListener
import com.khhhm.worefa.adapters.dummy.DummyContent

class MainActivity : AppCompatActivity(), OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        var companyFragment:CompanyFragment= CompanyFragment()
        supportFragmentManager.beginTransaction().add(R.id.main_frame,companyFragment).addToBackStack(null).commit()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeFragment:HomeFragment= HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.main_frame,homeFragment).commit()
        setContentView(R.layout.activity_main)

    }

}

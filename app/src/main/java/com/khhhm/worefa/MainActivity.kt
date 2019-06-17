package com.khhhm.worefa

//import androidx.navigation.fragment.NavHostFragment.findNavController

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.khhhm.worefa.AppointFragment.OnListFragmentInteractionListener
import com.khhhm.worefa.data.entitys.Appointment

class MainActivity : AppCompatActivity(), OnListFragmentInteractionListener {

    override fun onListFragmentInteraction(item: Any) {
        var fragment:Any
        if(item is Appointment) {
            fragment=loginFragment()
            supportFragmentManager.beginTransaction().add(R.id.main_frame, fragment).addToBackStack(null)
                .commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
  //      val homeFragment=HomeFragment();

   //     supportFragmentManager.beginTransaction().replace(R.id.main_frame,homeFragment).commit()
        setContentView(R.layout.activity_main)


    }

    override fun onSupportNavigateUp()=findNavController(this,R.id.nav_host).navigateUp()


}

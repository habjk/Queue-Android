package com.khhhm.worefa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.khhhm.worefa.viewmodels.UserViewModel

import com.khhhm.worefa.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {
  //  private lateinit var  binding;
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View?{
        // Inflate the layout for this fragment
           // val  view:View?=inflater.inflate(R.layout.fragment_signup, container, false)
        val binding:FragmentSignupBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_signup,container,false)
        val view:View=binding.root
        userViewModel=ViewModelProviders.of(this).get(UserViewModel::class.java)

         binding.user
        binding.userViewModel=this.userViewModel

        binding.executePendingBindings()
        return view
    }


}
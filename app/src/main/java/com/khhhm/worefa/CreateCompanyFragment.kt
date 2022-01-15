package com.khhhm.worefa


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.khhhm.worefa.data.entitys.Company
import com.khhhm.worefa.databinding.FragmentCreateCompanyBinding
import com.khhhm.worefa.viewmodels.CompanyViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class CreateCompanyFragment : Fragment() {
    private lateinit var companyViewModel: CompanyViewModel
    private lateinit var company:Company
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=FragmentCreateCompanyBinding.inflate(inflater)
        companyViewModel=ViewModelProviders.of(this).get(CompanyViewModel::class.java)

        binding.clickListener=companyViewModel.createBtnOnClickListener()

        binding.comp=companyViewModel.newCompany

        binding.executePendingBindings()
        return binding.root
    }


}

package com.khhhm.worefa.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.khhhm.worefa.data.WorefaDatabase
import com.khhhm.worefa.data.dao.AppointmentDao
import com.khhhm.worefa.data.dao.CompanyDao
import com.khhhm.worefa.data.entitys.Company
import com.khhhm.worefa.data.network.CompanyApiService
import com.khhhm.worefa.data.repository.AppointmentRepository
import com.khhhm.worefa.data.repository.CompanyRepository

class CompanyViewModel(application: Application) : AndroidViewModel(application) {

    private val companyRepository:CompanyRepository

    init{
        val companyDao:CompanyDao=WorefaDatabase.getDatabase(application).companyDao()

        companyRepository= CompanyRepository.getInstance(companyDao,CompanyApiService.getInstance())

    }
    fun getCompanys(): LiveData<List<Company>> {return this.companyRepository.getAllCompany()}
    fun reload(){
        this.companyRepository.reloadCompany()
        this.companyRepository.getCompany(5)
    }
}
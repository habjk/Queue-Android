package com.khhhm.worefa.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.khhhm.worefa.data.dao.CompanyDao
import com.khhhm.worefa.data.entitys.Company
import com.khhhm.worefa.data.network.CompanyApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class CompanyRepository private constructor(private val companyDao: CompanyDao,private val companyApiService: CompanyApiService){


    fun getAllCompany()=this.companyDao.getAllCompanys()

    fun getCompany(id:Long){
        GlobalScope.launch (Dispatchers.IO){
            val company=companyApiService.getCompany(id).await().body();
            if(company!=null){
            companyDao.insertAll(company)
            }
        }
    }
    fun reloadCompanys(){

        GlobalScope.launch (Dispatchers.IO) {
            val companys =
            //companyApiService.getAllCompany().await().body()
                companyDao.getAllCompanys().value
             }
    }


    companion object{
        @Volatile private var instance: CompanyRepository? = null

        fun getInstance(companyDao: CompanyDao,companyApiService: CompanyApiService) =
            instance ?: synchronized(this) {
                instance ?: CompanyRepository(companyDao,companyApiService).also { instance = it }
            }
    }
}
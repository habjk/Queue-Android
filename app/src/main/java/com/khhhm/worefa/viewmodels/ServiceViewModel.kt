package com.khhhm.worefa.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.khhhm.worefa.data.WorefaDatabase
import com.khhhm.worefa.data.dao.ServicesDao
import com.khhhm.worefa.data.repository.ServicesRepository

class ServiceViewModel(application: Application):AndroidViewModel(application) {

    private val servicesRepository:ServicesRepository

    init {
        val servicesDao: ServicesDao =WorefaDatabase.getDatabase(application).servicesDao()
        servicesRepository= ServicesRepository.getInstance(servicesDao)
    }
}
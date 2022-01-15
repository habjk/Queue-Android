package com.khhhm.worefa.data.repository

import com.khhhm.worefa.data.dao.CompanyDao
import com.khhhm.worefa.data.dao.ServicesDao

class ServicesRepository private constructor(private val servicesDao: ServicesDao){

    fun getAllByCompanyId(companyID:Long) = this.servicesDao.getAllByCompanyId(companyID)

    fun getSingleById(id:Long) = this.servicesDao.getSingleById(id);

    companion object{
        @Volatile private var instance: ServicesRepository? = null

        fun getInstance(servicesDao: ServicesDao) =
            instance ?: synchronized(this) {
                instance ?: ServicesRepository(servicesDao).also { instance = it }
            }
    }
}
package com.khhhm.worefa.data.repository

import com.khhhm.worefa.data.dao.AppointmentDao
import com.khhhm.worefa.data.dao.CompanyDao
import com.khhhm.worefa.data.entitys.Appointment
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class AppointmentRepository private constructor(private val appointmentDao: AppointmentDao){

    fun getAllAppointment() = this.appointmentDao.getAllappointments()

    fun getAppointment(appId:Int) = this.appointmentDao.getAppointment(appId)

    suspend fun insertAppointment(appointment: Appointment){
        withContext(IO){
            appointmentDao.insertAppointment(appointment)
        }
    }
    suspend fun deleteAppointment(appointment: Appointment){
        withContext(IO){
            appointmentDao.deleteAppointment(appointment)
        }
    }
    suspend fun updateAppointment(appointment: Appointment){
        withContext(IO){
            appointmentDao.updateAppointment(appointment)
        }
    }

    companion object{
        @Volatile private var instance: AppointmentRepository? = null

        fun getInstance(appointmentDao: AppointmentDao) =
            instance ?: synchronized(this) {
                instance ?: AppointmentRepository(appointmentDao).also { instance = it }
            }
    }
}
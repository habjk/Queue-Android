package com.khhhm.worefa.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.khhhm.worefa.data.WorefaDatabase
import com.khhhm.worefa.data.dao.AppointmentDao
import com.khhhm.worefa.data.repository.AppointmentRepository

class AppointmentViewModel(application: Application):AndroidViewModel(application) {

    private val appointmentRepository:AppointmentRepository

    init {
        val appointmentDao:AppointmentDao=WorefaDatabase.getDatabase(application).appointmentDao()
        appointmentRepository= AppointmentRepository.getInstance(appointmentDao)
    }
}
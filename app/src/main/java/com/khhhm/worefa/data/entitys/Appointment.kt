package com.khhhm.worefa.data.entitys

import androidx.room.*
import java.util.*

@Entity(tableName = "appointment",
        foreignKeys = [ForeignKey(entity = User::class,parentColumns = ["email"],childColumns = ["user"]),
        ForeignKey(entity = Services::class,parentColumns = ["Id"],childColumns = ["service_id"])],
        indices = [Index("user"),Index("service_id")]
    )
data class Appointment(@PrimaryKey(autoGenerate = true) @ColumnInfo(name="Id") val Id:Int,
                       @ColumnInfo(name="service_id") val serviceId:Long,
                       @ColumnInfo(name="user") val user:String,
                       @ColumnInfo(name="time") val time:Calendar= Calendar.getInstance()) {
}
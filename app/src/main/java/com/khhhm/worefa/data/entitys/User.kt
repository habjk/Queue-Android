package com.khhhm.worefa.data.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "user")
data class User(
    @ColumnInfo(name="fname") val fname:String,
    @ColumnInfo(name="mname") val mname:String,
    @ColumnInfo(name="lname") val lname:String,
    @PrimaryKey @ColumnInfo(name="email") val email:String,
    @ColumnInfo(name="phoneNo") val phoneNo:String,
    @ColumnInfo(name="password") val password:String ):Serializable
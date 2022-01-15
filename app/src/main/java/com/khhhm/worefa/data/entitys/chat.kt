package com.khhhm.worefa.data.entitys

import androidx.room.*
import java.sql.Timestamp

@Entity(tableName = "feed",
    foreignKeys = [ForeignKey(entity = Company::class,parentColumns = ["Id"],childColumns = ["companyId"]),
    ForeignKey(entity = User::class,parentColumns = ["phone_no"],childColumns = ["user_id"])],
    indices = [Index("user_id"),Index("companyId")])

data class chat(
                @PrimaryKey(autoGenerate = true) @ColumnInfo(name="Id") val Id:Int,
                @ColumnInfo(name = "companyId") val companyId:Int,
                @ColumnInfo(name="user_id") val user_id:String,
                @ColumnInfo(name="message") val message:String,
                @ColumnInfo(name="is_from_me") val is_from_me:String,
                @ColumnInfo(name = "file_path") val file_path:String)
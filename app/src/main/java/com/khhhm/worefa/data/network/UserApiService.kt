package com.khhhm.worefa.data.network

import com.khhhm.worefa.data.entitys.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApiService {
    @GET("users/{id}")
    fun getUserById(@Path("id") id:Long):Deferred<Response<User>>

    @GET("users")
    fun getUserByEmail(@Query("email") email:String):Deferred<Response<User>>

    @POST("users")
    fun postUser(newUser: User):Deferred<Response<Void>>
}
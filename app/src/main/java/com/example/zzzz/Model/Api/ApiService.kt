package com.example.zzzz.Model.Api

import com.example.zzzz.Model.Models.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("Users")
    fun GetAllStudent(): Call<List<User>>
}
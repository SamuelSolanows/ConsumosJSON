package com.example.zzzz.Model.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private var retrofit = Retrofit.Builder()
        .baseUrl("http://10.194.144.236:7777/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var tokent = ""
    var build = retrofit.create(ApiService::class.java)
}
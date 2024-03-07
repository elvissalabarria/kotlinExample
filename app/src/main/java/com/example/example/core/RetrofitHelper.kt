package com.example.example.core

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}
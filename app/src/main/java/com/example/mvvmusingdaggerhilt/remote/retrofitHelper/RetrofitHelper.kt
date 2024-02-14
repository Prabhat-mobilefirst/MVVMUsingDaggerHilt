package com.example.mvvmusingdaggerhilt.remote.retrofitHelper

import com.example.mvvmusingdaggerhilt.remote.retrofit.ZomatoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val BASE_URL="https://raw.githubusercontent.com/Prabhat-kr-Tiwari/Zomatodata/main/"
    /*
        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }*/
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api:ZomatoApi by lazy {
        retrofit.create(ZomatoApi::class.java)
    }
}
package com.example.mvvmusingdaggerhilt.remote.retrofit

import com.example.mvvmusingdaggerhilt.local.response.DataItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

const val BASE_URL3="https://raw.githubusercontent.com/Prabhat-kr-Tiwari/Zomatodata/main/"
interface ZomatoApi {
    @GET("data.json")
    suspend fun getData(
        @Header("Content-Type") str:String
    ): Response<DataItem>

}
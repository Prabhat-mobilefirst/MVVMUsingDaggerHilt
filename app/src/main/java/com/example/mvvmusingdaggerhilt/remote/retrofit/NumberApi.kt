package com.example.mvvmusingdaggerhilt.remote.retrofit

import com.example.mvvmusingdaggerhilt.local.response.DataItem
import com.example.mvvmusingdaggerhilt.local.response.NumberResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


const val BASE_URL = "http://numbersapi.com/"
const val BASE_URL2="https://raw.githubusercontent.com/Prabhat-kr-Tiwari/Zomatodata/main/"

interface NumberApi {


    @GET("{number}")
    suspend fun getNumberFact(
        @Header("Content-Type") str:String,
        @Path("number") number: Int
    ): Response<NumberResponse>
//    @GET("data.json")
//    suspend fun getData():Response<DataItem>


}
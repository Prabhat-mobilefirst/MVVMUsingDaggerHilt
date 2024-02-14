package com.example.mvvmusingdaggerhilt.local

import android.util.Log
import com.example.mvvmusingdaggerhilt.local.response.DataItem
import com.example.mvvmusingdaggerhilt.local.response.NumberResponse
import com.example.mvvmusingdaggerhilt.remote.retrofit.NumberApi
import com.example.mvvmusingdaggerhilt.util.Status
import com.example.mvvmusingdaggerhilt.util.Result
import retrofit2.http.GET

class NumberRepo(private val numberApi: NumberApi) {

    //call the remote server

    suspend fun getNumberFact(number: Int): Result<NumberResponse> {
        Log.d("PRABHAT", "getNumberFact: here")
        return try {
            Log.d("PRABHAT", "getNumberFact: now")

            val response=numberApi.getNumberFact("application/json",number)
            Log.d("PRABHAT", "getNumberFact: $response")
            Log.d("PRABHAT", "getNumberFact: ${response.body()}")

            return Result(
                Status.SUCCESS,
                response.body(),
                null
            )


        } catch (e: Exception) {
            Log.d("PRABHAT", "getNumberFact: Error ${e.message}")
            Result(Status.ERROR,null,null)


        }

    }


 /*   suspend fun getZomato():Result<DataItem>{
        val response=numberApi.getData()
        Log.d("PRABHAT2", "getZomato: ")
        return Result(Status.SUCCESS,response.body(),null)


//        return RetrofitHelper.api.getZomatoData()
    }*/
}
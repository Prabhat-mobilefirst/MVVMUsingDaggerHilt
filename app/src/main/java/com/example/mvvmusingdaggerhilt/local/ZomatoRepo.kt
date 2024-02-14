package com.example.mvvmusingdaggerhilt.local

import android.util.Log
import com.example.mvvmusingdaggerhilt.local.response.DataItem
import com.example.mvvmusingdaggerhilt.remote.retrofit.ZomatoApi
import com.example.mvvmusingdaggerhilt.util.Result
import com.example.mvvmusingdaggerhilt.util.Status
import javax.inject.Inject

class ZomatoRepo @Inject constructor(private val zomatoApi: ZomatoApi) {
    suspend fun getZomato(): Result<DataItem> {
        val response=zomatoApi.getData("application/json")
        Log.d("PRABHAT2", "getZomato: ${response.body()} ")
        return Result(Status.SUCCESS,response.body(),null)


//        return RetrofitHelper.api.getZomatoData()
    }
}
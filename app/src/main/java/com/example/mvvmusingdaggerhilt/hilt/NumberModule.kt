package com.example.mvvmusingdaggerhilt.hilt

import android.util.Log
import com.example.mvvmusingdaggerhilt.local.NumberRepo
import com.example.mvvmusingdaggerhilt.remote.retrofit.BASE_URL
import com.example.mvvmusingdaggerhilt.remote.retrofit.BASE_URL2
import com.example.mvvmusingdaggerhilt.remote.retrofit.NumberApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton
import kotlin.math.log

@InstallIn(SingletonComponent::class)
@Module
object NumberModule {


    @Provides
    @Singleton
    fun provideRetrofitInterface(): NumberApi {

        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(NumberApi::class.java)

    }
    @Provides
    @Singleton
    fun provideRepo(numberApi: NumberApi):NumberRepo{
        return NumberRepo(numberApi)
    }




}
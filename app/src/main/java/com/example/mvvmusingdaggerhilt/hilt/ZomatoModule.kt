package com.example.mvvmusingdaggerhilt.hilt

import com.example.mvvmusingdaggerhilt.local.ZomatoRepo
import com.example.mvvmusingdaggerhilt.remote.retrofit.BASE_URL2
import com.example.mvvmusingdaggerhilt.remote.retrofit.ZomatoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ZomatoModule {

    //zomato data
    @Provides
    @Singleton
    fun provideRetrofitInterfaceForZomato(): ZomatoApi {
        return Retrofit.Builder().baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ZomatoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideZomatoRepo(zomatoApi: ZomatoApi): ZomatoRepo {

        return ZomatoRepo(zomatoApi)

    }

}
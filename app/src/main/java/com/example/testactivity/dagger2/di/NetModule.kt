package com.example.testactivity.dagger2.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @ClassName: NetModule
 * @Description: TODO()
 * @author: penggangggui
 * @date: 2021/7/20 5:27 下午
 * @Version: 1.0
 */

@Module
class NetModule {

    @Singleton
    @Provides
    fun providerRetrofit(client: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl("https://google.com")
            .build()
    }

    @Singleton
    @Provides
    fun providerApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providerClient() : OkHttpClient{
        return OkHttpClient.Builder().build()
    }

}
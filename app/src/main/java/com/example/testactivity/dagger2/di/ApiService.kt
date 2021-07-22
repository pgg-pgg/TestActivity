package com.example.testactivity.dagger2.di

import retrofit2.Call
import retrofit2.http.GET

/**
 * @ClassName: ApiService
 * @Description: TODO()
 * @author: penggangggui
 * @date: 2021/7/20 5:26 下午
 * @Version: 1.0
 */
interface ApiService {
    @GET("user/info")
    fun requestUserInfo(): Call<String>
}
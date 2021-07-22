package com.example.testactivity.dagger2

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testactivity.R
import com.example.testactivity.dagger2.di.ApiService
import com.example.testactivity.dagger2.di.DaggerApplicationComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * @ClassName: Dagger2Activity
 * @Description: TODO()
 * @author: penggangggui
 * @date: 2021/7/19 3:38 下午
 * @Version: 1.0
 */
class Dagger2Activity : AppCompatActivity(){
    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var client: OkHttpClient

    @Inject
    lateinit var client2: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger2)
        MyApplication.getAppComponent().inject(this)
        Log.e("pgg", retrofit.toString())
        Log.e("pgg", apiService.toString())
        Log.e("pgg", client.toString())
        Log.e("pgg", client2.toString())
    }
}
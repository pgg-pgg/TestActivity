package com.example.testactivity.dagger2

import android.app.Application
import com.example.testactivity.dagger2.di.ApplicationComponent
import com.example.testactivity.dagger2.di.DaggerApplicationComponent

/**
 * @ClassName: MyApplication
 * @Description: TODO()
 * @author: penggangggui
 * @date: 2021/7/20 6:01 下午
 * @Version: 1.0
 */
class MyApplication : Application() {
    companion object {
        private val appComponent = DaggerApplicationComponent.create()
        fun getAppComponent(): ApplicationComponent {
            return appComponent
        }
    }
}
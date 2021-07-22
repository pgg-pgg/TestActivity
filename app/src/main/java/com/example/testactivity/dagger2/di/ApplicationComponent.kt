package com.example.testactivity.dagger2.di

import com.example.testactivity.dagger2.Dagger2Activity
import dagger.Component
import javax.inject.Singleton

/**
 * @ClassName: ApplicationComponent
 * @Description: TODO()
 * @author: penggangggui
 * @date: 2021/7/20 5:32 下午
 * @Version: 1.0
 */
@Singleton
@Component(modules = [NetModule::class])
interface ApplicationComponent {

    fun inject(activity: Dagger2Activity)
}
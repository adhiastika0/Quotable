package com.d121211029.quotable

import android.app.Application
import com.d121211029.quotable.data.AppContainer
import com.d121211029.quotable.data.DefaultAppContainer

class MyApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate(){
        super.onCreate()
        container = DefaultAppContainer()
    }
}
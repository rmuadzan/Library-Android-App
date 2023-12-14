package com.D121211052.libraryapp

import android.app.Application
import com.D121211052.libraryapp.data.AppContainer
import com.D121211052.libraryapp.data.DefaultAppContainter

class MyApplication: Application() {
    lateinit var containter: AppContainer

    override fun onCreate() {
        super.onCreate()
        containter = DefaultAppContainter()
    }
}


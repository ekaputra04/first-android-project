package com.example.belajar_android_dasar

import android.app.Application
import android.util.Log

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.i("myApplication","Application Created")
    }
}
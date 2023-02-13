package com.example.myapplication

import android.app.Application
import android.util.Log

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("app", "App init 1")
    }
}

class App2: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("app","App init 2")
    }
}
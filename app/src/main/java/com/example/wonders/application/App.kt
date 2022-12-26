package com.example.wonders.application

import android.app.Application
import android.content.Context

open class App : Application() {

    companion object {
        private var _contextInst: Context? = null
        fun getContext(): Context? {
            return _contextInst
        }
    }

    override fun onCreate() {
        super.onCreate()
        _contextInst = applicationContext
    }

    override fun onTerminate() {
        super.onTerminate()
        _contextInst = null
    }

}
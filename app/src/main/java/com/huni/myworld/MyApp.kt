package com.huni.myworld

import android.app.Application
import com.huni.myworld.module.myDiModule
import org.koin.android.ext.android.startKoin

class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, myDiModule)
    }
}
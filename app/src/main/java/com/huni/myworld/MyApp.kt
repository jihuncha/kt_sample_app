package com.huni.myworld

import android.app.Application
import com.huni.myworld.di.myDiModule
import org.koin.android.ext.android.startKoin

class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, myDiModule)
    }
}
package com.huni.myworld.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.huni.myworld.R

class MainActivity : AppCompatActivity() {
    private val TAG: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
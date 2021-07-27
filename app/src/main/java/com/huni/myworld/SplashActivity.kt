package com.huni.myworld

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.huni.myworld.ui.MainActivity

class SplashActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG: String = SplashActivity::class.java.simpleName

    private var bt_next_step : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        bt_next_step = findViewById<Button>(R.id.bt_next_step)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_next_step -> {
                Log.d(TAG, "onClick - bt_next_step")
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }


}
package com.daday.jetpackpro.utils

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.daday.jetpackpro.R
import com.daday.jetpackpro.ui.home.MainActivity

class SplashScreenActivity : AppCompatActivity() {

    companion object {
        const val TIME_DELAY: Long = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, TIME_DELAY)
    }
}
package com.example.risingtest.src.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivitySplashBinding
import com.example.risingtest.src.main.MainActivity
import com.example.risingtest.src.main.login.LoginActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 1500)
    }
}
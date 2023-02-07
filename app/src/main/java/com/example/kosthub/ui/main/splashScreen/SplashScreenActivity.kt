package com.example.kosthub.ui.main.splashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.kosthub.R
import com.example.kosthub.application.MainActivity
import com.example.kosthub.ui.main.welcome.WelcomeFragment


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()


//        Handler().postDelayed(Runnable {
//            val intent = Intent(this@SplashScreenActivity, WelcomeFragment::class.java)
//            startActivity(intent)
//            finish()
//        }, 3000)

    }
}
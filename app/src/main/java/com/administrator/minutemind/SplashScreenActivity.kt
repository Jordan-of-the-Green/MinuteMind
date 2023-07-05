package com.administrator.minutemind

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)




        val backgroundImg : ImageView = findViewById(R.id.iv_logo1)
        val sideAnimation = AnimationUtils.loadAnimation(this,R.anim.slide )
       
        backgroundImg.startAnimation(sideAnimation)
        Handler().postDelayed({
            startActivity(Intent(this,Registration::class.java))
            finish()
        },3000)



    }
}
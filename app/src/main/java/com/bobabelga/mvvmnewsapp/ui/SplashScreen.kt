package com.bobabelga.mvvmnewsapp.ui


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bobaappsinc.wallpaperappmvvmv1.R
import kotlinx.coroutines.*


class SplashScreen : AppCompatActivity() {

    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        activityScope.launch {
            delay(800)

            val homeIntent = Intent(this@SplashScreen, NewsActivity::class.java)
            startActivity(homeIntent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }

    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }
}
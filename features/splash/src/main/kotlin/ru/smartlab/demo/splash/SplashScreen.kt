package ru.smartlab.demo.splash

import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit

fun AppCompatActivity.useSplash(isUsed: Boolean = true) {

    if (isUsed) {
        setContentView(SplashView(this))

        Thread {
            TimeUnit.MILLISECONDS.sleep(3000)

         startActivity(intent)
          finish()
        }.start()
    }
}
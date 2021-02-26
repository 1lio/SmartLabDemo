package ru.smartlab.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.nav_host_fragment, FeedMainFragment())
            .commit()*/
    }
}
package ru.smartlab.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.smartlab.demo.feed.fragments.FeedFragment
import ru.smartlab.demo.marketmap.fragments.MapMarket

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment, FeedFragment())
            .commit()
    }
}
package ru.smartlab.demo.feed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.smartlab.demo.feed.R

class FeedDetail : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)
        val v = inflater.inflate(R.layout.detail_fragment, group, false)


        return v
    }
}
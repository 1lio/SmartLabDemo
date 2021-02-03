package ru.smartlab.demo.feed.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import ru.smartlab.demo.feed.R

class HeaderView @JvmOverloads constructor(context: Context, attr: AttributeSet) :
    FrameLayout(context, attr) {


    init {

        LayoutInflater.from(context).inflate(R.layout.header_view, this, false)

    }
}
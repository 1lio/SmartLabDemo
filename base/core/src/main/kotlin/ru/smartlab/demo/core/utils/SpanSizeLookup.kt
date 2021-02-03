package ru.smartlab.demo.core.utils

import androidx.recyclerview.widget.GridLayoutManager

abstract class SpanSizeLookup : GridLayoutManager.SpanSizeLookup() {

    abstract var type: Int

    override fun getSpanSize(position: Int): Int {
        return type
    }

}
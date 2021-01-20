package ru.smartlab.demo.feed.row

import androidx.recyclerview.widget.RecyclerView

interface RowType {

    companion object {
        const val TEXT: Int = 0
        const val IMAGE: Int = 1
        const val VIDEO: Int = 2
    }

    fun getItemType(): Int

    fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder)

}

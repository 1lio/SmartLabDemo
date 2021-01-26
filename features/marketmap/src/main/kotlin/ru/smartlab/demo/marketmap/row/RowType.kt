package ru.smartlab.demo.marketmap.row

import androidx.recyclerview.widget.RecyclerView

interface RowType {

    companion object {
        const val DIVIDER: Int = 0
        const val GRID: Int = 1
    }

    fun getItemType(): Int

    fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder)

}

package ru.smartlab.demo.core.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {

    var list: List<T> = ArrayList()
    var isEdited: Boolean = false

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = list.size

    private fun getItem(i: Int): T = list[i]

    fun addAllAndNotify(items: List<T>) {
        this.list = items
        notifyDataSetChanged()
    }
}
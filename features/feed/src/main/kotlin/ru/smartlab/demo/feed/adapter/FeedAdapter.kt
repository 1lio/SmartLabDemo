package ru.smartlab.demo.feed.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.smartlab.demo.feed.factory.ViewHolderFactory
import ru.smartlab.demo.feed.row.RowType

class FeedAdapter(private val list: List<RowType>) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemViewType(position: Int): Int = list[position].getItemType()

    override fun onBindViewHolder(viewHolder: ViewHolder, pos: Int) {
        list[pos].onBindViewHolder(viewHolder)
    }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolderFactory.create(parent, viewType)

}
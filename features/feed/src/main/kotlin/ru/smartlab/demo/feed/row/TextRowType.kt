package ru.smartlab.demo.feed.row

import androidx.recyclerview.widget.RecyclerView
import ru.smartlab.demo.feed.factory.ViewHolderFactory
import ru.smartlab.demo.core.entity.Topic

class TextRowType(private val item: Topic) : RowType {

    override fun getItemType(): Int = RowType.TEXT

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder) {
        val holder = viewHolder as ViewHolderFactory.TextViewHolder

        holder.avatarImg.background
        holder.likeView.background

        holder.contentTextView.text = ("""
            ${item.title}
            
            ${item.content}
        """.trimIndent())
        holder.authorTextView.text = item.author.name
        holder.dateTextView.text = item.date

        holder.countViews.text = item.countViews.toString()
        holder.countComments.text = item.countComments.toString()
        holder.countLikes.text = item.countLikes.toString()
    }
}
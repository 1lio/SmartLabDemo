package ru.smartlab.demo.feed.row

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.smartlab.demo.core.entity.Topic
import ru.smartlab.demo.core.utils.Constants.BASE_SITE
import ru.smartlab.demo.feed.factory.ViewHolderFactory

class TextRowType(private val item: Topic) : RowType {

/*
    private lateinit var onItemClickListener: (() -> Unit)

    fun setOnItemClickListener(listener: () -> Unit){
        onItemClickListener = listener
    }
*/

    override fun getItemType(): Int = RowType.TEXT

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder) {
        val holder = viewHolder as ViewHolderFactory.TextViewHolder

        Picasso.get().load("$BASE_SITE/${item.author.avatarUrl}").into(holder.avatarImg)

        holder.likeView.background

        holder.contentTextView.text = ("""
            ${item.title}    
            ${item.content}
        """.trimIndent())
        holder.authorTextView.text = item.author.name
        holder.dateTextView.text = item.date

        holder.countViews.text = item.countReviews.toString()
        holder.countComments.text = item.countComments.toString()
        holder.countLikes.text = item.countLikes.toString()


        holder.contentTextView.setOnClickListener {
            //   onItemClickListener()
        }
    }


}
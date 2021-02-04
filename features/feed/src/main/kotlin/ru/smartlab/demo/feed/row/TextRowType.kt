package ru.smartlab.demo.feed.row

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.smartlab.demo.core.entity.Topic
import ru.smartlab.demo.core.utils.Constants.BASE_SITE
import ru.smartlab.demo.feed.R
import ru.smartlab.demo.feed.factory.ViewHolderFactory

class TextRowType(private val item: Topic, private val context: Context) : RowType {

    override fun getItemType(): Int = RowType.TEXT

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder) {

        val holder = viewHolder as ViewHolderFactory.TextViewHolder

        holder.itemView.setOnClickListener {
            // Open Detail Fragment
        }

        Picasso.get().load("$BASE_SITE/${item.author.avatarUrl}").into(holder.avatarImg)

        holder.likeView.setOnClickListener {
            val bg =
                if (item.isLiked) {
                    item.isLiked = false
                    item.countLikes--
                    holder.likeView.setColorFilter(
                        ContextCompat.getColor(context, R.color.gray),
                        android.graphics.PorterDuff.Mode.MULTIPLY
                    )
                    ContextCompat.getDrawable(context, R.drawable.ic_favorite_border)
                } else {
                    item.isLiked = true
                    item.countLikes++
                    holder.likeView.setColorFilter(
                        ContextCompat.getColor(context, R.color.red),
                        android.graphics.PorterDuff.Mode.MULTIPLY
                    )
                    ContextCompat.getDrawable(context, R.drawable.ic_favorite)
                }

            holder.countLikes.text = item.countLikes.toString()
            holder.likeView.setImageDrawable(bg)
        }

        holder.titleTextView.text = item.title
        holder.contentTextView.text = item.content

        holder.authorTextView.text = item.author.name
        holder.dateTextView.text = item.date

        holder.countViews.text = item.countReviews.toString()
        holder.countComments.text = item.countComments.toString()
        holder.countLikes.text = item.countLikes.toString()
    }
}
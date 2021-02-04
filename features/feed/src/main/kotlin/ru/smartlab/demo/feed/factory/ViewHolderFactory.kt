package ru.smartlab.demo.feed.factory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import ru.smartlab.demo.feed.R
import ru.smartlab.demo.feed.row.RowType
import ru.smartlab.demo.feed.view.CircleImageView


object ViewHolderFactory {

    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val avatarImg: CircleImageView = view.findViewById(R.id.avatarImg)
        val authorTextView: TextView = view.findViewById(R.id.authorText)
        val dateTextView: TextView = view.findViewById(R.id.dateText)

        val countViews: TextView = view.findViewById(R.id.countViews)
        val countComments: TextView = view.findViewById(R.id.countComments)
        val countLikes: TextView = view.findViewById(R.id.countLikes)

        val likeView: AppCompatImageView = view.findViewById(R.id.likeImg)

        val titleTextView: TextView = view.findViewById(R.id.titleText)
        val contentTextView: TextView = view.findViewById(R.id.contentText)
    }

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        /*  val avatarImg: CircleImageView = view.findViewById(R.id.avatarImg)
          val authorTextView: TextView = view.findViewById(R.id.authorText)
          val dateTextView: TextView = view.findViewById(R.id.dateText)

          val countViews: TextView = view.findViewById(R.id.countViews)
          val countComments: TextView = view.findViewById(R.id.countComments)
          val countLikes: TextView = view.findViewById(R.id.countLikes)

          val likeView: AppCompatImageView = view.findViewById(R.id.likeImg)

          val contentTextView: TextView = view.findViewById(R.id.contentText)
          val contentImage: AppCompatImageView = view.findViewById(R.id.imageContent)*/
    }

    class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        /*  val avatarImg: CircleImageView = view.findViewById(R.id.avatarImg)
          val authorTextView: TextView = view.findViewById(R.id.authorText)
          val dateTextView: TextView = view.findViewById(R.id.dateText)

          val countViews: TextView = view.findViewById(R.id.countViews)
          val countComments: TextView = view.findViewById(R.id.countComments)
          val countLikes: TextView = view.findViewById(R.id.countLikes)

          val likeView: AppCompatImageView = view.findViewById(R.id.likeImg)

          val contentTextView: TextView = view.findViewById(R.id.contentText)
          val contentVideoView: VideoView = view.findViewById(R.id.videoContentView)*/
    }


    fun create(parent: ViewGroup, itemType: Int): RecyclerView.ViewHolder {

        return when (itemType) {
            RowType.TEXT -> TextViewHolder(R.layout.card_text.inflate(parent))
            RowType.IMAGE -> ImageViewHolder(R.layout.card_text_img.inflate(parent))
            RowType.VIDEO -> VideoViewHolder(R.layout.card_text_video.inflate(parent))
            else -> VideoViewHolder(R.layout.card_text.inflate(parent))
        }
    }

    private fun Int.inflate(parent: ViewGroup) =
        LayoutInflater.from(parent.context).inflate(this, parent, false)

}
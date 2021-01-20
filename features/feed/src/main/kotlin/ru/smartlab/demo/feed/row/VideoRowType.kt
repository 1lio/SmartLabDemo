package ru.smartlab.demo.feed.row

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.smartlab.demo.feed.factory.ViewHolderFactory

class VideoRowType : RowType {

    override fun getItemType(): Int = RowType.VIDEO

    private fun getOnClickListener(): View.OnClickListener {
        return View.OnClickListener {
            Log.i("ROW TYPE", "text is CLicked")
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder) {
        val holder: ViewHolderFactory.VideoViewHolder =
            viewHolder as ViewHolderFactory.VideoViewHolder

        val videoSource = "http://www.cats.com/cat-speak.3gp"
      //  holder.contentVideoView.setVideoURI(Uri.parse(videoSource))
    }
}
package ru.smartlab.demo.feed.row

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.smartlab.demo.feed.factory.ViewHolderFactory

class ImageRowType(private val text: String) : RowType {

    override fun getItemType(): Int = RowType.IMAGE

    private fun getOnClickListener(): View.OnClickListener {
        return View.OnClickListener {
            Log.i("ROW TYPE", "text is CLicked")
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder) {
        val buttonViewHolder: ViewHolderFactory.ImageViewHolder =
            viewHolder as ViewHolderFactory.ImageViewHolder

        //buttonViewHolder.contentTextView.text = text
       // buttonViewHolder.contentTextView.setOnClickListener(getOnClickListener())
    }
}
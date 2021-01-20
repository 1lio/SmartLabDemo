package ru.smartlab.demo.feed.row

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.smartlab.demo.feed.factory.ViewHolderFactory

class TextRowType(private val text: String) : RowType {

    override fun getItemType(): Int = RowType.TEXT

    private fun getOnClickListener(): View.OnClickListener {
        return View.OnClickListener {
            Log.i("ROW TYPE", "text is CLicked")
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder) {
        val holder: ViewHolderFactory.TextViewHolder = viewHolder as ViewHolderFactory.TextViewHolder
        //holder.contentTextView.text = text
    }
}
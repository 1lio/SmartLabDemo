package ru.smartlab.demo.marketmap.factory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import ru.smartlab.demo.marketmap.R
import ru.smartlab.demo.marketmap.row.RowType

object MarketHolderFactory {

    class DividerHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: AppCompatImageView = view.findViewById(R.id.titleDivider)
    }

    class GridHolder(view: View? = null) : RecyclerView.ViewHolder(view!!) {

        // ???
    }


    fun create(parent: ViewGroup, itemType: Int): RecyclerView.ViewHolder {
        return when (itemType) {
            RowType.DIVIDER -> DividerHolder(R.layout.group_divider.inflate(parent))
            RowType.GRID -> GridHolder()
            else -> GridHolder()
        }
    }

    private fun Int.inflate(parent: ViewGroup) =
        LayoutInflater.from(parent.context).inflate(this, parent, false)

}
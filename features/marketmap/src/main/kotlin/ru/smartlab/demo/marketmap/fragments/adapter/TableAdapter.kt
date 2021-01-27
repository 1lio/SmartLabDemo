package ru.smartlab.demo.marketmap.fragments.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ru.smartlab.demo.core.base.BaseViewHolder
import ru.smartlab.demo.core.entity.ExchangeInstrument
import ru.smartlab.demo.marketmap.R

class TableAdapter(private var list: List<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var ctx: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        ctx = parent.context
        return if (viewType == 1) {
            DirectionViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.group_divider, parent, false)
            )
        } else {
            CompanyViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.table_item, parent, false)
            )
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DirectionViewHolder -> holder.bind(list[position] as String)
            is CompanyViewHolder -> holder.bind(list[position] as ExchangeInstrument)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return if (list[position] is String) 1 else 0
    }

    fun addAllAndNotify(items: List<Any>) {
        this.list = items
        notifyDataSetChanged()
    }

    class DirectionViewHolder(v: View) : BaseViewHolder<String>(v) {

        private val texTitle: TextView = v.findViewById(R.id.titleDivider)

        override fun bind(item: String) {
            texTitle.text = item
        }
    }

    inner class CompanyViewHolder(v: View) : BaseViewHolder<ExchangeInstrument>(v) {

        private val tableItemContainer: ConstraintLayout = v.findViewById(R.id.tableItemContainer)
        private val textTicket: TextView = v.findViewById(R.id.textTicket)
        private val texTitle: TextView = v.findViewById(R.id.texTitle)
        private val textPrice: TextView = v.findViewById(R.id.textPrice)
        private val texPercent: TextView = v.findViewById(R.id.texPercent)
        private val textTurnover: TextView = v.findViewById(R.id.textTurnover)
        private val imageIndicator: AppCompatImageView = v.findViewById(R.id.imageIndicator)

        override fun bind(item: ExchangeInstrument) {
            tableItemContainer.setBackgroundColor(getColor(item.lastPriceChange.toInt()))

            textTicket.text = item.ticket
            texTitle.text = item.name
            textPrice.text = item.lastPrice.toString()
            texPercent.text = item.lastPriceChange.toString()
            textTurnover.text = item.turnover.toString()

            imageIndicator.setImageResource(R.drawable.ic_arrow)
            imageIndicator.rotation = if (item.lastPriceChange <= 0) 0.0f else 180.0f
        }

        private fun getColor(percent: Int): Int {

            val color = when (percent) {
                in 1..2 -> R.color.green1
                in 2..4 -> R.color.green2
                in 4..6 -> R.color.green3
                in 8..10 -> R.color.green4
                in 10..100 -> R.color.green5

                in -1 downTo -2 -> R.color.red1
                in -2 downTo -4 -> R.color.red2
                in -4 downTo -6 -> R.color.red3
                in -8 downTo -10 -> R.color.red4
                in -10 downTo -100 -> R.color.red5
                else -> R.color.gray
            }

            return ContextCompat.getColor(ctx!!, color)

        }
    }
}
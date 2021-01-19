package ru.smartlab.demo.marketmap.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import ru.smartlab.demo.marketmap.R
import ru.smartlab.demo.marketmap.fakeRepo.MoscowExchangeRepository
import ru.smartlab.demo.marketmap.model.ExchangeInstrument

class TableAdapter : RecyclerView.Adapter<TableAdapter.TableViewHolder>() {

    private val list: List<ExchangeInstrument> = MoscowExchangeRepository().getListStocks()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        return TableViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.table_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = list.size

    inner class TableViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private val textTicket: TextView = v.findViewById(R.id.textTicket)
        private val texTitle: TextView = v.findViewById(R.id.texTitle)
        private val textPrice: TextView = v.findViewById(R.id.textPrice)
        private val texPercent: TextView = v.findViewById(R.id.texPercent)
        private val textTurnover: TextView = v.findViewById(R.id.textTurnover)
        private val imageIndicator: AppCompatImageView = v.findViewById(R.id.imageIndicator)

        fun bind(position: Int) {

            val item = list[position]

            textTicket.text = item.ticket
            texTitle.text = item.name
            textPrice.text = item.lastPrice.toString()
            texPercent.text = item.lastPriceChange.toString()
            textTurnover.text = item.turnover

            imageIndicator.setImageResource(R.drawable.ic_arrow)
            imageIndicator.rotation = if (item.lastPriceChange <= 0) 180.0f else 0.0f
        }
    }
}
package ru.smartlab.demo.marketmap.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.smartlab.demo.core.enums.ExInstrument.Direction
import ru.smartlab.demo.marketmap.R
import ru.smartlab.demo.marketmap.fakeRepo.MoscowExchangeRepository
import ru.smartlab.demo.marketmap.fragments.adapter.TableAdapter

// Demo Variant - not optimized (BAD VARIANT)
class TableMarket : Fragment() {


    private var listDirection = listOf<Any>(
        Direction.GAZ_AND_OIL,
        Direction.FINANCE,
        Direction.METALLURGY,
        Direction.IT, Direction.CONSUMER_SECTOR,
        Direction.ENERGY,
        Direction.TRANSPORT,
        Direction.CHEMISTRY,
        Direction.AGRO,
        Direction.MECHANICAL_ENGINEERING,
        Direction.CONSTRUCTION,
        Direction.HEALTHCARE,
        Direction.OTHER
    )


    private val gazAndOilList =
        MoscowExchangeRepository().getStockList { it.group == Direction.GAZ_AND_OIL }
    private val financeList =
        MoscowExchangeRepository().getStockList { it.group == Direction.FINANCE }
    private val metallurgyList =
        MoscowExchangeRepository().getStockList { it.group == Direction.METALLURGY }
    private val itList = MoscowExchangeRepository().getStockList { it.group == Direction.IT }
    private val consumerSectorList =
        MoscowExchangeRepository().getStockList { it.group == Direction.CONSUMER_SECTOR }
    private val energyList =
        MoscowExchangeRepository().getStockList { it.group == Direction.ENERGY }
    private val transportList =
        MoscowExchangeRepository().getStockList { it.group == Direction.TRANSPORT }
    private val chemistryList =
        MoscowExchangeRepository().getStockList { it.group == Direction.CHEMISTRY }
    private val agroList = MoscowExchangeRepository().getStockList { it.group == Direction.AGRO }
    private val mechanicalEngineeringList =
        MoscowExchangeRepository().getStockList { it.group == Direction.MECHANICAL_ENGINEERING }
    private val constructionList =
        MoscowExchangeRepository().getStockList { it.group == Direction.CONSTRUCTION }
    private val otherList = MoscowExchangeRepository().getStockList { it.group == Direction.OTHER }

    fun setListAdapter(): List<Any> {
        return listOf<Any>(
            Direction.GAZ_AND_OIL,
            gazAndOilList[0],
            gazAndOilList[1],
            gazAndOilList[3],
            gazAndOilList[4],
            gazAndOilList[5],
            Direction.FINANCE,
            financeList[0],
            financeList[1],
            Direction.METALLURGY,
            metallurgyList[0],
            metallurgyList[1]
        )
    }

    private lateinit var tableRecyclerView: RecyclerView
    private lateinit var adapter: TableAdapter
    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)

        val v = inflater.inflate(R.layout.table_fragment, group, false)
        tableRecyclerView = v.findViewById(R.id.tableRecyclerView)
        adapter = TableAdapter(setListAdapter())
        val glm = GridLayoutManager(context, 4).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (adapter.getItemViewType(position)) {
                        0 -> 1
                        else -> 4
                    }
                }
            }
        }

        tableRecyclerView.layoutManager = glm
        tableRecyclerView.adapter = TableAdapter(setListAdapter())
        return v
    }
}
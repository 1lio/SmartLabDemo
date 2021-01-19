package ru.smartlab.demo.marketmap.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.smartlab.demo.marketmap.R
import ru.smartlab.demo.marketmap.fakeRepo.MoscowExchangeRepository
import ru.smartlab.demo.marketmap.fakeRepo.MoscowExchangeRepository.StockGroup

class TableMarket : Fragment() {

    // Tmp
    val listData = MoscowExchangeRepository().getListStocks()

    val gazAndOil = listData.map { it.group == StockGroup.GAZ_AND_OIL }
    val finance = listData.map { it.group == StockGroup.FINANCE }
    val metallurgy = listData.map { it.group == StockGroup.METALLURGY }
    val it = listData.map { it.group == StockGroup.IT }
    val consumerSector = listData.map { it.group == StockGroup.CONSUMER_SECTOR }
    val energy = listData.map { it.group == StockGroup.ENERGY }
    val transport = listData.map { it.group == StockGroup.TRANSPORT }
    val chemistry = listData.map { it.group == StockGroup.CHEMISTRY }
    val agro = listData.map { it.group == StockGroup.AGRO }
    val mechanicalEngineering = listData.map { it.group == StockGroup.MECHANICAL_ENGINEERING }
    val other = listData.map { it.group == StockGroup.OTHER }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val v = inflater.inflate(R.layout.table_fragment, container, false)

        val recycler: RecyclerView = v.findViewById(R.id.tableRecycler)



        return v
    }

}
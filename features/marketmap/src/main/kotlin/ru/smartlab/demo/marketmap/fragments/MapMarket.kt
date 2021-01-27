package ru.smartlab.demo.marketmap.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import ru.smartlab.demo.core.entity.ExchangeInstrument
import ru.smartlab.demo.core.enum.ExInstrument.Direction
import ru.smartlab.demo.marketmap.fakeRepo.MoscowExchangeRepository

class MapMarket : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View {
        super.onCreateView(inflater, group, state)

        getStockWidth()

        return GridLayout(context)

    }

    private val list = MoscowExchangeRepository().getListStocks()
    private val allTurnover = list.sumOf { it.turnover } // 101_983_000_000

    private fun getStockWidth() {

        // Считаем общую сумму оборотов. Пусть с потерей точности (100.0f%)
        Log.i(TAG, "All: $allTurnover")

        // Расчитываем сколько каждая отрасль занимает %
        val gazAndOilWidth = list.percent { it.group == Direction.GAZ_AND_OIL }
        val financeWidth = list.percent { it.group == Direction.FINANCE }
        val metallurgyWidth = list.percent { it.group == Direction.METALLURGY }
        val itWidth = list.percent { it.group == Direction.IT }
        val consumerSectorWidth = list.percent { it.group == Direction.CONSUMER_SECTOR }
        val energyWidth = list.percent { it.group == Direction.ENERGY }
        val transportWidth = list.percent { it.group == Direction.TRANSPORT }
        val chemistryWidth = list.percent { it.group == Direction.CHEMISTRY }
        val agroWidth = list.percent { it.group == Direction.AGRO }
        val mechanicalEngineeringWidth =
            list.percent { it.group == Direction.MECHANICAL_ENGINEERING }
        val constructionWidth = list.percent { it.group == Direction.CONSTRUCTION }
        val otherWidth = list.percent { it.group == Direction.OTHER }

        val listG = listOf(
            gazAndOilWidth,
            financeWidth,
            metallurgyWidth,
            itWidth,
            consumerSectorWidth,
            energyWidth,
            transportWidth,
            chemistryWidth,
            agroWidth,
            mechanicalEngineeringWidth,
            constructionWidth,
            otherWidth
        )


        listG.forEach {
            Log.i(TAG, "getStockWidth: $it")
        }
        // Расчитываем сколько конкретно акция занимает процентов


    }

    private inline fun List<ExchangeInstrument>.percent(filter: (inst: ExchangeInstrument) -> Boolean): Float {
        return 100.0f * this.filter { filter(it) }.sumOf { it.turnover } / allTurnover
    }


    companion object {
        const val TAG = "MAP_MARKET"
    }
}
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
        val gazAndOilWidth = list.percent(Direction.GAZ_AND_OIL)
        val financeWidth = list.percent(Direction.FINANCE)
        val metallurgyWidth = list.percent(Direction.METALLURGY)
        val itWidth = list.percent(Direction.IT)
        val consumerSectorWidth = list.percent(Direction.CONSUMER_SECTOR)
        val energyWidth = list.percent(Direction.ENERGY)
        val transportWidth = list.percent(Direction.TRANSPORT)
        val chemistryWidth = list.percent(Direction.CHEMISTRY)
        val agroWidth = list.percent(Direction.AGRO)
        val mechanicalEngineeringWidth = list.percent(Direction.MECHANICAL_ENGINEERING)
        val constructionWidth = list.percent(Direction.CONSTRUCTION)
        val otherWidth = list.percent(Direction.OTHER)

       val listGroups = listOf(gazAndOilWidth, financeWidth, metallurgyWidth, itWidth,
            consumerSectorWidth, energyWidth, transportWidth, chemistryWidth, agroWidth,
            mechanicalEngineeringWidth, constructionWidth, otherWidth)


       // val listGroups = mutableListOf<String>()
      //  Log.i(TAG, listGroups.size.toString())

     /*   val directionInstance = Direction

        Direction::class.java.fields.forEach {
            val field = it.get(directionInstance) as String

            listGroups.add(list.percent(field).toString())

        }

        Log.i(TAG, listGroups.size.toString())*/

        listGroups.forEach {
            Log.i(TAG, "${Math.ceil(it.toDouble())} %")
        }

        Log.i(TAG, "Sum ${Math.ceil(listGroups.sum().toDouble())}")
        // Расчитываем сколько конкретно акция занимает процентов

    }

    private fun List<ExchangeInstrument>.percent(filter: String): Float {
        return 100.0f * this.filter { it.group == filter }.sumOf { it.turnover } / allTurnover
    }


    companion object {
        const val TAG = "MAP_MARKET"
    }
}
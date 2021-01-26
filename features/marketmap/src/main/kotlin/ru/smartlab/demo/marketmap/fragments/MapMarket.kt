package ru.smartlab.demo.marketmap.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import ru.smartlab.demo.core.enum.ExInstrument
import ru.smartlab.demo.marketmap.fakeRepo.MoscowExchangeRepository

class MapMarket : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View {
        super.onCreateView(inflater, group, state)

        getStockWidth()

        return GridLayout(context)

    }

    private fun getStockWidth() {

        // Считаем общую сумму оборотов. Пусть с потерей точности (100%)
        val allTurnover =
            MoscowExchangeRepository().getStockList { it.group == ExInstrument.Direction.AGRO }
                .sumOf { it.turnover.toInt() }
        Log.i(TAG, "getStockWidth: $allTurnover")

        // Расчитываем сколько каждая отрасль занимает %


        // Расчитываем сколько конкретно акция занимает процентов


    }

    companion object {
        const val TAG = "MAP_MARKET"
    }
}
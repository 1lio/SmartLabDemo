package ru.smartlab.demo.marketmap.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import ru.smartlab.demo.marketmap.fakeRepo.MoscowExchangeRepository

class MapMarket : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View {
        super.onCreateView(inflater, group, state)

        getStockWidth()

        return GridLayout(context)

    }

    private fun getStockWidth() {


        // Считаем общую сумму оборотов. Пусть с потерей точности
        MoscowExchangeRepository().getStockList().sumBy { it.turnover.toInt() }


    }
}
package ru.smartlab.demo.marketmap.fragments.adapter

import android.content.Context
import androidx.fragment.app.FragmentManager
import ru.smartlab.demo.marketmap.R
import ru.smartlab.demo.marketmap.fragments.MapMarket
import ru.smartlab.demo.marketmap.fragments.TableMarket
import ru.smartlab.demo.marketmap.model.ExchangeInstrument
import ru.smartlab.demo.tabs.BasePagerAdapter

class TabAdapter(private val context: Context, fm: FragmentManager) :
    BasePagerAdapter<ExchangeInstrument>(fm) {

    init {

        countItems = 2

        items = {
            when (it) {
                0 -> MapMarket()
                else -> TableMarket()
            }
        }

        title = {

            when (it) {
                0 -> context.resources.getString(R.string.map)
                else -> context.resources.getString(R.string.table)
            }
        }
    }

}
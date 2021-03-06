package ru.smartlab.demo.marketmap.fragments.adapter

import android.content.Context
import androidx.fragment.app.FragmentManager
import ru.smartlab.demo.core.base.BasePagerAdapter
import ru.smartlab.demo.marketmap.R
import ru.smartlab.demo.marketmap.fragments.MapMarket
import ru.smartlab.demo.marketmap.fragments.TableMarket

class TabAdapter(context: Context, fm: FragmentManager) : BasePagerAdapter(fm) {

    init {
        setFragments(listOf(MapMarket(), TableMarket()))
        setTabTitles(listOf(context.resources.getString(R.string.map), context.resources.getString(R.string.table)))
    }
}
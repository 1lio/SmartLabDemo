package ru.smartlab.demo.marketmap.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import ru.smartlab.demo.marketmap.fragments.adapter.TabAdapter
import ru.smartlab.demo.tabs.R

class MarketTabFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val v = inflater.inflate(R.layout.fr_tab, container, false)

        val pager: ViewPager = v.findViewById(R.id.viewPager)
        pager.adapter = TabAdapter(context!!, fragmentManager!!)

        val tabLayout: TabLayout = v.findViewById(R.id.tabLayout)
        tabLayout.post { tabLayout.setupWithViewPager(pager) }

        return v
    }
}
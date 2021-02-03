package ru.smartlab.demo.feed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import ru.smartlab.demo.feed.R
import ru.smartlab.demo.feed.adapter.TabAdapterFeed

// Основной фрагмент для новостей включает три таба (Главная, Все подряд, лучшие)
class FeedMainFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)

        val v = inflater.inflate(R.layout.fr_tab, group, false)

        val pager: ViewPager = v.findViewById(R.id.viewPager)
        pager.adapter = TabAdapterFeed(requireContext(), childFragmentManager)

        val tabLayout: TabLayout = v.findViewById(R.id.tabLayout)
        tabLayout.post { tabLayout.setupWithViewPager(pager) }

        return v
    }
}
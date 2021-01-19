package ru.smartlab.demo.tabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

abstract class BasePagerAdapter<T>(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var list = listOf<T>()

    var items: (pos: Int) -> Fragment = { Fragment() }
    var title: (pos: Int) -> String = { "" }

    override fun getItem(position: Int) = items(position)
    override fun getCount() = list.size

    override fun getPageTitle(position: Int) = title(position)
}
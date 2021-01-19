package ru.smartlab.demo.tabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

abstract class BasePagerAdapter<T>(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    var items: (pos: Int) -> Fragment = { Fragment() }
    var title: (pos: Int) -> String = { "" }
    var countItems: Int = 2

    override fun getItem(position: Int) = items(position)
    override fun getCount() = countItems

    override fun getPageTitle(position: Int) = title(position)
}
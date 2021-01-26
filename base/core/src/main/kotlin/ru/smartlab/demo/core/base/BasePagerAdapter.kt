package ru.smartlab.demo.core.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

abstract class BasePagerAdapter<T>(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = mutableListOf<Fragment>()
    private val title = mutableListOf<String>()

    override fun getItem(position: Int) = fragments[position]
    override fun getCount() = fragments.size
    override fun getPageTitle(position: Int) = title[position]

    fun setFragments(list: List<Fragment>) {
        fragments.addAll(list)
    }

    fun setTabTitles(list: List<String>) {
        title.addAll(list)
    }
}
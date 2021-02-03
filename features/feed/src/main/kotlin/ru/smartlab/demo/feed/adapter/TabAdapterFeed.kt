package ru.smartlab.demo.feed.adapter

import android.content.Context
import androidx.fragment.app.FragmentManager
import ru.smartlab.demo.core.base.BasePagerAdapter
import ru.smartlab.demo.feed.R
import ru.smartlab.demo.feed.fragments.FeedFragment
import ru.smartlab.demo.feed.fragments.FeedPopularFragment
import ru.smartlab.demo.feed.fragments.FeedType

class TabAdapterFeed(context: Context, fm: FragmentManager) : BasePagerAdapter(fm) {

    init {

        setFragments(
            listOf(
                FeedFragment(FeedType.FEED),
                FeedFragment(FeedType.FEED_ALL),
                FeedPopularFragment()
            )
        )

        setTabTitles(
            listOf(
                context.resources.getString(R.string.main),
                context.resources.getString(R.string.all),
                context.resources.getString(R.string.top)
            )
        )
    }
}
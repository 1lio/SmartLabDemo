package ru.smartlab.demo.feed.adapter

import android.content.Context
import androidx.fragment.app.FragmentManager
import ru.smartlab.demo.core.base.BasePagerAdapter
import ru.smartlab.demo.feed.R
import ru.smartlab.demo.feed.fragments.FeedFragment
import ru.smartlab.demo.feed.fragments.FeedType

class TabAdapterFeedTop(context: Context, fm: FragmentManager) : BasePagerAdapter(fm) {

    init {
        setFragments(
            listOf(
                FeedFragment(FeedType.FEED_TOP_DAY),
                FeedFragment(FeedType.FEED_TOP_WEEK),
                FeedFragment(FeedType.FEED_TOP_MOUTH),
                FeedFragment(FeedType.FEED_TOP_ALL),
            )
        )

        setTabTitles(
            listOf(
                context.resources.getString(R.string.top_1),
                context.resources.getString(R.string.top_7),
                context.resources.getString(R.string.top_30),
                context.resources.getString(R.string.top_all),
            )
        )
    }
}
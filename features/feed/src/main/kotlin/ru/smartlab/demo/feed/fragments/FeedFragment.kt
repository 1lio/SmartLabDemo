package ru.smartlab.demo.feed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.smartlab.demo.feed.R
import ru.smartlab.demo.feed.adapter.FeedAdapter
import ru.smartlab.demo.feed.row.RowType
import ru.smartlab.demo.feed.row.TextRowType
import ru.smartlab.demo.network.api.SmartLabApi.FeedTop
import ru.smartlab.demo.network.impl.SmartLabParserImpl

// Данный фрагмент отражет ленту новостей
class FeedFragment(private val feedType: Int = 0) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)

        val v = inflater.inflate(R.layout.feed_fragment, group, false)
        val items: ArrayList<RowType> = arrayListOf()
        val recyclerView: RecyclerView = v.findViewById(R.id.feedRecycler)

        recyclerView.layoutManager = (LinearLayoutManager(group!!.context))

        val adapter = FeedAdapter(items)
        recyclerView.adapter = adapter

        val repository = SmartLabParserImpl()

        GlobalScope.launch(Dispatchers.Main) {

            val feedFlow = when (feedType) {
                FeedType.FEED -> repository.getFeed()
                FeedType.FEED_ALL -> repository.getFeedAll()
                FeedType.FEED_TOP_DAY -> repository.getFeedTop(FeedTop.TOP_DAY)
                FeedType.FEED_TOP_WEEK -> repository.getFeedTop(FeedTop.TOP_WEEK)
                FeedType.FEED_TOP_MOUTH -> repository.getFeedTop(FeedTop.TOP_MOUNT)
                FeedType.FEED_TOP_ALL -> repository.getFeedTop(FeedTop.TOP_ALL)
                else -> repository.getFeed()
            }

            feedFlow.collect {
                it.forEach { topic ->
                    // TODO: Определить тип ячейки
                    items.add(TextRowType(topic))
                    adapter.notifyItemChanged(items.size)
                }
            }
        }

        return v
    }

/*    companion object {

        private var feedType = 0 // 0-главная 1-все 2день 3-7 дней 4 -месяц 5 завсе время

        fun setType(typeFeed: Int) {
            feedType = typeFeed
        }
    }*/
}
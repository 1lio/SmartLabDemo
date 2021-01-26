package ru.smartlab.demo.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import ru.smartlab.demo.feed.adapter.FeedAdapter
import ru.smartlab.demo.feed.model.Feed
import ru.smartlab.demo.feed.row.RowType
import ru.smartlab.demo.feed.row.TextRowType
import kotlin.collections.ArrayList

// FIX RECURSING ID'S IN ROWS

class FeedFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FeedAdapter
    var items: ArrayList<RowType> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)

        val v = inflater.inflate(R.layout.feed_fragment, group, false)

        recyclerView = v.findViewById(R.id.feedRecycler)
        recyclerView.layoutManager = (LinearLayoutManager(group!!.context))

        adapter = FeedAdapter(items)
        recyclerView.adapter = adapter

        GlobalScope.launch(Dispatchers.Main) {
            initd().collect {
                items.add(TextRowType(it))
                adapter.notifyItemChanged(items.size)

            }
        }

        return v
    }


    private suspend fun initd(): Flow<Feed> = flow {

        val jsoupDocument = Jsoup
            .connect("https://smart-lab.ru/")
            .userAgent("Chrome/4.0.249.0 Safari/532.5")
            .referrer("http://www.google.com")
            .timeout(3000)
            .get()

        val elements: Elements = jsoupDocument.select(".topic")

        for (e in elements) {

            val title = e.select(".title ").text()
            // val link = e.select(".title ").attr("abs:href")

            val date = e.select(".date ").text()

            val author = e.select(".author").text()

            val likes = e.select(".total").text().let {
                if (it.isNullOrEmpty()) 0 else it.toInt()
            }

            // Пока не получается корректно спарсить колличество просмотров
            val views = e.select(".views-total").attr("abs:title").let {

                if (it.isNullOrEmpty()) 0 else it.toInt()
            }

            val comments = e.select(".comments-total").select(".red").text().let {
                if (it.isNullOrEmpty()) 0 else it.toInt()
            }


            val feed = Feed(
                title = title,
                content = "",
                author = author,
                date = date,
                countViews = views,
                countComments = comments,
                countLikes = likes
            )

            emit(feed)
        }

    }.flowOn(Dispatchers.IO)

    companion object {
        const val TAG = "FEED_FRAGMENT"
    }
}
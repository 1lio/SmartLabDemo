package ru.smartlab.demo.feed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import ru.smartlab.demo.feed.adapter.FeedAdapter
import ru.smartlab.demo.feed.model.Feed
import ru.smartlab.demo.feed.row.RowType
import ru.smartlab.demo.feed.row.TextRowType
import ru.smartlab.demo.feed.row.VideoRowType
import java.util.*
import kotlin.collections.ArrayList

// FIX RECURSING ID'S IN ROWS

class FeedFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    //  lateinit var adapter: FeedAdapter
    var items: ArrayList<RowType> = ArrayList()
    var rnd: Random = Random(1337)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val v = inflater.inflate(R.layout.feed_fragment, container, false)

        recyclerView = v.findViewById(R.id.feedRecycler)

        recyclerView.layoutManager = (LinearLayoutManager(container!!.context))


        for (i in 0..14) {
            when (rnd.nextInt(3)) {
                RowType.TEXT -> items.add(TextRowType("TEXT EJ $i"))
                //   RowType.IMAGE -> items.add(ImageRowType("SD"))
                RowType.VIDEO -> items.add(VideoRowType())
            }
        }

        //  adapter = FeedAdapter(items)

        //  recyclerView.adapter = adapter


        // tmp

        val listFeed = mutableListOf<Feed>()

        GlobalScope.launch {

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

                //   Log.i(TAG, feed.toString())

            }
        }

        return v
    }

    companion object {
        const val TAG = "FEED_FRAGMENT"
    }
}
package ru.smartlab.demo.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.smartlab.demo.feed.adapter.FeedAdapter
import ru.smartlab.demo.feed.row.RowType
import ru.smartlab.demo.feed.row.TextRowType
import ru.smartlab.demo.feed.row.VideoRowType
import java.util.*
import kotlin.collections.ArrayList

// FIX RECURSING ID'S IN ROWS

class FeedFragment: Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: FeedAdapter
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

        adapter = FeedAdapter(items)

        recyclerView.adapter = adapter

        return v


    }

}
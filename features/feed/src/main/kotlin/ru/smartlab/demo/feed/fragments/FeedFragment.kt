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
import ru.smartlab.demo.feed.datastore.api.ParseService
import ru.smartlab.demo.feed.row.RowType
import ru.smartlab.demo.feed.row.TextRowType

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
            ParseService().subscribeBNews().collect {
                items.add(TextRowType(it))
                adapter.notifyItemChanged(items.size)

            }
        }

        return v
    }

}
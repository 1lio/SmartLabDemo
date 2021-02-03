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
import kotlinx.coroutines.launch
import ru.smartlab.demo.feed.R
import ru.smartlab.demo.feed.adapter.FeedAdapter
import ru.smartlab.demo.feed.row.RowType
import ru.smartlab.demo.feed.row.TextRowType
import ru.smartlab.demo.network.impl.SmartLabRetrofitImpl

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

        val repository = SmartLabRetrofitImpl()

        GlobalScope.launch(Dispatchers.Main) {

            val resp = repository.getFeed()

            resp.collection.forEach {
                items.add(TextRowType(it.convertToTopic()))
                adapter.notifyItemChanged(items.size)
            }

        }

        return v
    }

}
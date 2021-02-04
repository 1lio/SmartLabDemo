package ru.smartlab.demo.feed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.smartlab.demo.feed.R
import ru.smartlab.demo.feed.view.CircleImageView

class FeedDetail : Fragment() {

    private lateinit var authorName: TextView
    private lateinit var authorAvatar: CircleImageView
    private lateinit var publicDate: TextView
    private lateinit var title: TextView
    private lateinit var content: TextView
    private lateinit var share: ImageView
    private lateinit var favoriteCount: TextView
    private lateinit var favoriteImage: ImageView
    private lateinit var likeCount: TextView
    private lateinit var likeImage: ImageView
    private lateinit var commentsCounterView: TextView
    private lateinit var commentRecycler: RecyclerView
    private lateinit var buttonSendComment: Button

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)
        val v = inflater.inflate(R.layout.detail_fragment, group, false)

        authorName = v.findViewById(R.id.authorNameDetatil)
        authorAvatar = v.findViewById(R.id.avatarImg)
        publicDate = v.findViewById(R.id.dateDetail)
        title = v.findViewById(R.id.titleDetail)
        content = v.findViewById(R.id.contentDetail)
        share = v.findViewById(R.id.shareDetail)
        favoriteCount = v.findViewById(R.id.favoriteDetailImage)
        favoriteImage = v.findViewById(R.id.favoriteCountDetail)
        likeCount = v.findViewById(R.id.likeDetail)
        likeImage = v.findViewById(R.id.likeCountDetail)
        commentsCounterView = v.findViewById(R.id.countComments)
        commentRecycler = v.findViewById(R.id.commentRecycler)
        buttonSendComment = v.findViewById(R.id.sendComment)

        return v
    }
}
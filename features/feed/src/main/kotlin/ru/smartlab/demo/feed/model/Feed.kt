package ru.smartlab.demo.feed.model

data class Feed(

    val title: String,
    val content: String,
    val author: String,     // USE MODEL
    val date: String,

    val countViews: Int = 0,
    val countComments: Int = 0,
    val countLikes: Int = 0
)
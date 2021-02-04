package ru.smartlab.demo.core.entity

data class Comment(
    val cId: Int = 0, // CommentID
    val author: User,
    val date: String,
    val content: String = "",
    var raiting: Int = 0,
    var topicAuthor: Boolean = false, // ???
)
package ru.smartlab.demo.core.entity

class Topic(

    val title: String = "",
    val content: String = "",
    val author: User = User("default"),
    val date: String = "",
    val countReviews: Int = 0,
    val countComments: Int = 0,
    val countLikes: Int = 0
)
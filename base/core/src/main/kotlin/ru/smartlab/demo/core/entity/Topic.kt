package ru.smartlab.demo.core.entity

data class Topic(

    val title: String = "",
    val content: String = "",

    val author: User = User("default"),
    val date: String = "",

    val countViews: Int = 0,
    val countComments: Int = 0,
    val countLikes: Int = 0
)
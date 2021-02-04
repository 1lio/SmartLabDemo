package ru.smartlab.demo.core.entity

class Topic(
    val tId: Int = 0,

    val title: String = "",
    val content: String = "",
    val author: User = User("default"),
    val date: String = "",
    val countReviews: Int = 0,
    val countComments: Int = 0,

    var countLikes: Int = 0,
    var isLiked: Boolean = false,

    var countFavorites: Int = 0,
    var isFavorite: Boolean = false,

    var listComments: List<Comment> = listOf()
)
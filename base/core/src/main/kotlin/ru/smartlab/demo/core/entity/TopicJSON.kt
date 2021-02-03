package ru.smartlab.demo.core.entity

data class TopicJSON(
    val topicId: Long,
    val title: String,
    val date: String,
    val countComments: String,
    val blogTitle: String,
    val blogUrl: String,
    val authorName: String,
    val authorColor: String,
    val authorLogin: String
) {

    fun convertToTopic(): Topic {
        return Topic(
            title = title,
            content = "",
            author = User(authorName),
            date = date,
            countViews = 0,
            countComments = countComments.toInt(),
            countLikes = 0
        )
    }
}

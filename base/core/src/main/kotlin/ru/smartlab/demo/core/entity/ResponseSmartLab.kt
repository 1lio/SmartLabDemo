package ru.smartlab.demo.core.entity

data class ResponseSmartLab(
    val collection: List<TopicJSON>,
    val current: Int,
    val overal: Int
)
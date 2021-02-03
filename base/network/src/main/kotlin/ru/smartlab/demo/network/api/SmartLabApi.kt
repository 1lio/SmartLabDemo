package ru.smartlab.demo.network.api

import kotlinx.coroutines.flow.Flow
import ru.smartlab.demo.core.entity.Topic

interface SmartLabApi {

    // Лента состоит из топиков с форума
    fun getFeed(): Flow<List<Topic>>

    // Все топики (включая без рейтинга)
    fun getFeedAll(): Flow<List<Topic>>

    // Лучшие топики по топам ( 0-день, 1-7дней, 2-30дней, 3-За Все время
    fun getFeedTop(top: Int = FeedTop.TOP_DAY): Flow<List<Topic>>

    // Заранее сохраненные константы
    object FeedTop {
        const val TOP_DAY = 0
        const val TOP_WEEK = 1
        const val TOP_MOUNT = 2
        const val TOP_ALL = 3
    }
}

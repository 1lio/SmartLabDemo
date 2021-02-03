package ru.smartlab.demo.network.api

import kotlinx.coroutines.flow.Flow
import ru.smartlab.demo.core.entity.Topic

interface SmartLabApi {

    fun getFeed(): Flow<List<Topic>>

}
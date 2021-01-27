package ru.smartlab.demo.repo.api

import kotlinx.coroutines.flow.Flow
import ru.smartlab.demo.core.entity.Topic

interface SmartLabApi {

    fun getFeed(): Flow<List<Topic>>

}
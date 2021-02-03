package ru.smartlab.demo.network.impl

import retrofit2.http.GET
import ru.smartlab.demo.core.entity.ResponseSmartLab

interface SmartLabRetrofit {

    @GET("/rest")
    suspend fun getFeed(): ResponseSmartLab

}
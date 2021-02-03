package ru.smartlab.demo.network.impl

import retrofit2.http.GET
import ru.smartlab.demo.core.entity.ResponseSmartLab
import ru.smartlab.demo.network.service.RetrofitService

class SmartLabRetrofitImpl {

    private val service = RetrofitService().provideRetrofit().create(SmartLabRetrofit::class.java)

    @GET("/")
    suspend fun getFeed(): ResponseSmartLab {
        return service.getFeed()
    }
}
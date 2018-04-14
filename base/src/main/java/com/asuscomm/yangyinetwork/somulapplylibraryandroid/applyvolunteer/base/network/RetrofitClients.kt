package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitClients {
    private val services: HashMap<Class<out Any>, Any> = HashMap()

    fun <T> getService(type: Class<out T>): T {
        var service: T? = services.get(type) as T?

        if (service == null) {
            val client = Retrofit.Builder()
                    .baseUrl(UrlUtils.HOST)
                    .addConverterFactory(GsonConverterFactory.create(GsonHolder.gson))
                    .build()

            service = client.create(type)
            services.put(type, service!!)
        }

        return service
    }
}

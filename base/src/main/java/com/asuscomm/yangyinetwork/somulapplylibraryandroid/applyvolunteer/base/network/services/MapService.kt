package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.network.services


import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.domain.LibraryMapDto

import retrofit2.Call
import retrofit2.http.GET

interface MapService {
    @GET("/api/v1/maps")
    fun getLibraryMaps(): Call<List<LibraryMapDto>>
}

package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.domain

import com.google.gson.annotations.SerializedName

data class LibraryMapDto(
        @SerializedName("_id")
        var id: String? = null,
        var name: String? = null,
        var location_road: String? = null,
        var province: String? = null)

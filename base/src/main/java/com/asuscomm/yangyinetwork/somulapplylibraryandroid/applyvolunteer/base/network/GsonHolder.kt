package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.network

import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.debug.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder

object GsonHolder {
    private lateinit var mGson: Gson

    val gson: Gson
        get() {
            if (!::mGson.isInitialized) {
                synchronized(GsonHolder::class.java) {
                    if (!::mGson.isInitialized) {
                        Log.d("Initializing Gson")
                        mGson = GsonBuilder()
                                .create()
                    }
                }
            }

            return mGson
        }
}

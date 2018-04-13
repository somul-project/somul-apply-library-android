package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base

/**
 * Created by jaeyeong on 13/04/2018.
 */

data class Volunteer(
        var is_speaker: Boolean,
        var name: String,
        var email: String,
        var phone: String,

        var password: String,
        var session_time: String,
        var library_id: Int) {

    class Builder {
        var is_speaker: Boolean? = null
        var name: String? = null
        var email: String? = null
        var phone: String? = null

        var password: String? = null
        var session_time: String? = null
        var library_id: Int? = null

        fun create(): Volunteer {
            return Volunteer(is_speaker!!, name!!, email!!, phone!!, password!!, session_time!!, library_id!!)
        }
    }
}

package com.asuscomm.yangyinetwork.somul_apply_library_android.applyvolunteer.base

import java.util.*

/**
 * Created by jaeyeong on 13/04/2018.
 */

data class Voluteer(
        var id: Int,
        var name: String,
        var email: String,
        var phone: String,

        var password: String,
        var is_email_verified: Boolean,
        var email_sended_at: Date,
        var session_time: String,
        var library_id: Int
)

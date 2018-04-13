package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.Volunteer

import kotlinx.android.synthetic.main.activity_apply.*


class ApplyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)

        btn_next.setOnClickListener { saveVolunteerInfoAndGoNext() }
    }

    private fun saveVolunteerInfoAndGoNext() {
        saveVolunteer()
    }

    private fun saveVolunteer() {
        val builder = Volunteer.Builder()
                .apply {
                    is_speaker = radio_type.checkedRadioButtonId == radio_type_speaker.id
                    name = autotv_name.text.toString()
                    email = autotv_email.text.toString()
                    phone = autotv_phone.text.toString()
                    password = et_password.text.toString()
                }
    }
}

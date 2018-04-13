package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.Volunteer
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.debug.Log
import kotlinx.android.synthetic.main.fragment_personalnfo.view.*

/**
 * Created by jaeyeong on 13/04/2018.
 */

class PersonalinfoFragment: Fragment() {
    companion object {
        fun newInstance(): PersonalinfoFragment {
            return PersonalinfoFragment()
        }
    }

    private lateinit var mNavigator: ApplyNavigator
    private lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d()
        mView = inflater.inflate(
                R.layout.fragment_personalnfo, container, false)

        mView.btn_next.setOnClickListener {
            saveVolunteerInfoAndGoNext()
        }

        return mView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ApplyNavigator) {
            mNavigator = context
        }

        if (context is ApplyNavigator) {
            mNavigator = context
        }
    }

    fun saveVolunteerInfoAndGoNext() {
        Log.d()

        if (saveVolunteer()) {
            mNavigator.gotoSelectLibraryFragment()
        } else {
            showErrors()
        }
    }

    private fun showErrors() {
        Log.d()

        Toast.makeText(context, "errors", Toast.LENGTH_LONG)
    }

    private fun saveVolunteer(): Boolean {
        Log.d()
        val builder = Volunteer.Builder()
                .apply {
                    is_speaker = mView.radio_type.checkedRadioButtonId == mView.radio_type_speaker.id
                    name = mView.autotv_name.text.toString()
                    email = mView.autotv_email.text.toString()
                    phone = mView.autotv_phone.text.toString()
                    password = mView.et_password.text.toString()
                }

        mNavigator.savePersonalInfo(builder)

        return true
    }
}
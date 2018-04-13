package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by jaeyeong on 13/04/2018.
 */

class PersonalinfoFragment: Fragment() {
    companion object {
        const val TAG = "PersonalinfoFragment"

        fun newInstance(): PersonalinfoFragment {
            return PersonalinfoFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView: ")
        val v: View = inflater.inflate(
                R.layout.fragment_personalnfo, container, false)

        return v
    }
}
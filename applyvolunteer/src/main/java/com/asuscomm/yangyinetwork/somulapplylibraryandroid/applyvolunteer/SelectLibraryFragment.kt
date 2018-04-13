package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.debug.Log
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.ui.BaseFragment

/**
 * Created by jaeyeong on 13/04/2018.
 */

class SelectLibraryFragment: BaseFragment() {
    companion object {
        fun newInstance(): SelectLibraryFragment {
            return SelectLibraryFragment()
        }
    }

    private lateinit var mNavigator: ApplyNavigator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d()
        val v: View = inflater.inflate(
                R.layout.fragment_selectlibrary, container, false)

        return v
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ApplyNavigator) {
            mNavigator = context
        }
    }
}

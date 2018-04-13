package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.ui

import android.support.v4.app.Fragment

/**
 * Created by jaeyeong on 13/04/2018.
 */

open class BaseFragment: Fragment() {
    /**
     * @return true if it has consumed. Otherwise returns false
     */
    fun onBackPressed(): Boolean {
        return false
    }
}

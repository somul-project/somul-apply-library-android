package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.debug.Log

/**
 * Created by jaeyeong on 13/04/2018.
 */

abstract class BaseFragmentActivity: AppCompatActivity() {
    abstract fun getContentFrameId(): Int

    override fun onBackPressed() {
        Log.d()
        val fragment = supportFragmentManager.findFragmentById(getContentFrameId())

        var consumed = false
        if (fragment is BaseFragment) {
            consumed = fragment.onBackPressed()
        }

        if (consumed) {
            return
        }

        // Solved the issue that it show blank screen, just after activity Launched.
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d()
        super.onCreate(savedInstanceState)

        val savedFragment = supportFragmentManager.findFragmentById(getContentFrameId())
        if (savedFragment == null) {
            initFragment()
        }
    }

    fun initFragment() {
        Log.d()

        val newFragment = getInitialFragment()

        gotoFragment(newFragment, false)
    }

    abstract fun getInitialFragment(): Fragment

    fun gotoFragment(newFragment: Fragment, backstack: Boolean) {
        Log.d()
        if (!backstack) {
            supportFragmentManager.popBackStack()
        }

        supportFragmentManager.beginTransaction()
                .replace(getContentFrameId(), newFragment)
                .addToBackStack(null)
                .commit()
    }
}

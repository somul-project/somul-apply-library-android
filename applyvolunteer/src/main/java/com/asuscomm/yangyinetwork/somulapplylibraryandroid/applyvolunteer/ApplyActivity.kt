package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.Volunteer
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.debug.Log


class ApplyActivity : AppCompatActivity(), ApplyNavigator {
    private lateinit var mVolunteerBuilder: Volunteer.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)

        val savedFragment = supportFragmentManager.findFragmentById(R.id.contentFrame)
        if (savedFragment == null) {
            initFragment()
        }
    }

    private fun initFragment() {
        Log.d()
        val newFragment = PersonalinfoFragment.newInstance()

        gotoFragment(newFragment, false)
    }

    private fun gotoFragment(newFragment: Fragment, backstack: Boolean) {
        Log.d()
        if (!backstack) {
            supportFragmentManager.popBackStack()
        }

        supportFragmentManager.beginTransaction()
                .replace(R.id.contentFrame, newFragment)
                .addToBackStack(null)
                .commit()
    }

    override fun savePersonalInfo(volunteerBuilder: Volunteer.Builder) {
        Log.d()
        mVolunteerBuilder = volunteerBuilder
    }

    override fun gotoSelectLibraryFragment() {
        Log.d()
        val newFragment = SelectLibraryFragment.newInstance()
        gotoFragment(newFragment, true)
    }
}

interface ApplyNavigator {
    fun savePersonalInfo(volunteerBuilder: Volunteer.Builder)
    fun gotoSelectLibraryFragment()
}


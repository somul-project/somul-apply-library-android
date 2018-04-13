package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer

import android.os.Bundle
import android.support.v4.app.Fragment
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.Volunteer
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.debug.Log
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.ui.BaseFragmentActivity


class ApplyActivity : BaseFragmentActivity(), ApplyNavigator {

    private lateinit var mVolunteerBuilder: Volunteer.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)
    }

    // region BaseFragmentActivity
    override fun getContentFrameId(): Int {
        return R.id.contentFrame
    }

    override fun getInitialFragment(): Fragment {
        return PersonalinfoFragment.newInstance()
    }
    // endregion

    // region ApplyNavigator
    override fun savePersonalInfo(volunteerBuilder: Volunteer.Builder) {
        Log.d()
        mVolunteerBuilder = volunteerBuilder
    }

    override fun gotoSelectLibraryFragment() {
        Log.d()
        val newFragment = SelectLibraryFragment.newInstance()
        gotoFragment(newFragment, true)
    }
    // endregion
}

interface ApplyNavigator {
    fun savePersonalInfo(volunteerBuilder: Volunteer.Builder)
    fun gotoSelectLibraryFragment()
}


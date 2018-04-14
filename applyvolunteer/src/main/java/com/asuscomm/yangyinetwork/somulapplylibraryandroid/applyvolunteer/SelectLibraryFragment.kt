package com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.debug.Log
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.domain.LibraryMapDto
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.network.RetrofitClients
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.network.services.MapService
import com.asuscomm.yangyinetwork.somulapplylibraryandroid.applyvolunteer.base.ui.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
        Log.d("Initialize ")
        val v: View = inflater.inflate(
                R.layout.fragment_selectlibrary, container, false)

        return v
    }

    override fun onResume() {
        super.onResume()
        RetrofitClients.getService(MapService::class.java)
                .getLibraryMaps()
                .enqueue(object : Callback<List<LibraryMapDto>> {
                    override fun onResponse(call: Call<List<LibraryMapDto>>?, response: Response<List<LibraryMapDto>>?) {
                        Log.d("onResponse: ")
                        if (response!!.isSuccessful) {
                            Log.d("result=${response.body()}")
                        } else {
                            Log.d("onResponse: is not successful")
                        }
                    }

                    override fun onFailure(call: Call<List<LibraryMapDto>?>?, t: Throwable?) {
                        Log.d("onFailure: $call")
                    }
                })
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ApplyNavigator) {
            mNavigator = context
        }
    }
}

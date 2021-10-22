package com.aku.projectassignment.ui.locality

import android.util.Log
import android.widget.AdapterView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.aku.projectassignment.data.model.Locality
import com.aku.projectassignment.data.model.User
import com.aku.projectassignment.data.repository.UserRepository
import com.aku.projectassignment.ui.base.BaseViewModel
import com.aku.projectassignment.utils.common.*
import io.reactivex.disposables.CompositeDisposable

class LocalityViewModel(
    compositeDisposable: CompositeDisposable,
    private val userRepository: UserRepository
) : BaseViewModel(compositeDisposable) {

    val TAG = "LocalityViewModel"


    val launchResident: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()

    lateinit var provinceSelectionListener : AdapterView.OnItemSelectedListener

    override fun onCreate() {}


    fun onSubmit(province : Int, district: Int, tehsil: Int) {

        if (province !=0 && district!=0 && tehsil != 0){
            val locality = Locality()

            locality.province = locality.provinceList[province].code
            locality.district = locality.provinceList[province].district[district].code
            locality.tehsil = locality.provinceList[province].district[district].tehsil[tehsil].code

            userRepository.saveLocality(locality)
            launchResident.postValue(Event(emptyMap()))
        }else messageString.postValue("Look Like a Mistake, Please Select Again")



    }
}
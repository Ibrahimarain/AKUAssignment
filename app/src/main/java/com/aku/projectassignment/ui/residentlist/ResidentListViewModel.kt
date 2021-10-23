package com.aku.projectassignment.ui.residentlist


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.aku.projectassignment.data.local.db.entity.ResidentEntity
import com.aku.projectassignment.data.repository.ResidentRepository
import com.aku.projectassignment.data.repository.UserRepository
import com.aku.projectassignment.ui.base.BaseViewModel
import com.aku.projectassignment.utils.common.Event
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class ResidentListViewModel(
    private val compositeDisposable: CompositeDisposable,
    private val residentRepository: ResidentRepository,
    private val userRepository: UserRepository

) : BaseViewModel(compositeDisposable) {

    val residentLiveData: MutableLiveData<List<ResidentEntity>> = MutableLiveData()

    override fun onCreate() {
        getResidents()
    }

    private fun getResidents() {
        compositeDisposable.add(residentRepository
            .getAllResident()
            .subscribeOn(Schedulers.io())
            .subscribe({ list ->
                residentLiveData.postValue(list)

            },{ error ->
                messageString.postValue("getResidents: a ${error.localizedMessage}")

            }))
    }

}
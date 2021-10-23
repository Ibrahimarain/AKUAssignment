package com.aku.projectassignment.ui.summary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.aku.projectassignment.data.repository.ResidentRepository
import com.aku.projectassignment.data.repository.UserRepository
import com.aku.projectassignment.ui.base.BaseViewModel
import com.aku.projectassignment.utils.common.Resource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DashboardViewModel (
    private val compositeDisposable: CompositeDisposable,
    private val residentRepository: ResidentRepository,
    private val userRepository: UserRepository
) : BaseViewModel(compositeDisposable) {

    private val maleCountLiveData: MutableLiveData<Resource<Int>> = MutableLiveData()
    private val femaleCountLiveData: MutableLiveData<Resource<Int>> = MutableLiveData()
    private val marriedCountLiveData: MutableLiveData<Resource<Int>> = MutableLiveData()


    fun getMaleCount(): LiveData<Int> =
        Transformations.map(maleCountLiveData) { it.data }

    fun getFemaleCount(): LiveData<Int> =
        Transformations.map(femaleCountLiveData) { it.data }

    fun getMarriedCount(): LiveData<Int> =
        Transformations.map(marriedCountLiveData) { it.data }

    override fun onCreate() {

        compositeDisposable.add(
            residentRepository.getMaleResidentCount()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { maleCountLiveData.postValue(Resource.success(it)) },
                    {
                        maleCountLiveData.postValue(Resource.error())
                    })
        )

        compositeDisposable.add(
            residentRepository.getFemaleResidentCount()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { femaleCountLiveData.postValue(Resource.success(it)) },

                    {
                        femaleCountLiveData.postValue(Resource.error())
                    })
        )

        compositeDisposable.add(
            residentRepository.getMarriedStatusCount()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { marriedCountLiveData.postValue(Resource.success(it)) },

                    {
                        marriedCountLiveData.postValue(Resource.error())
                    })
        )


    }
}
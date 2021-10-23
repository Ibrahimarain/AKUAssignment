package com.aku.projectassignment.ui.summary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.aku.projectassignment.data.local.db.entity.LocalityCount
import com.aku.projectassignment.data.local.db.entity.MaritalCount
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
    private val maritalCountLiveData: MutableLiveData<Resource<MaritalCount>> = MutableLiveData()
    private val localityCountLiveData: MutableLiveData<Resource<LocalityCount>> = MutableLiveData()


    fun getMaleCount(): LiveData<Int> =
        Transformations.map(maleCountLiveData) { it.data }

    fun getFemaleCount(): LiveData<Int> =
        Transformations.map(femaleCountLiveData) { it.data }

    fun getMaritalCount(): LiveData<MaritalCount> =
        Transformations.map(maritalCountLiveData) { it.data }

    fun getLocalityCount(): LiveData<LocalityCount> =
        Transformations.map(localityCountLiveData) { it.data }


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
            residentRepository.getMaritalStatusCount()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { maritalCountLiveData.postValue(Resource.success(it)) },

                    {
                        maritalCountLiveData.postValue(Resource.error())
                    })
        )

        compositeDisposable.add(
            residentRepository.getLocalityWiseCount()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { localityCountLiveData.postValue(Resource.success(it)) },

                    {
                        localityCountLiveData.postValue(Resource.error())
                    })
        )


    }
}
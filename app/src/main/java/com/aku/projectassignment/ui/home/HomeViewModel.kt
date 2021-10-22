package com.aku.projectassignment.ui.home

import androidx.lifecycle.MutableLiveData
import com.aku.projectassignment.data.repository.UserRepository
import com.aku.projectassignment.ui.base.BaseViewModel
import com.aku.projectassignment.utils.common.Event
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel (
        compositeDisposable: CompositeDisposable,
        private val userRepository: UserRepository
) : BaseViewModel(compositeDisposable) {

    val launchAddSurvey: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()
    val launchAddLocality: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()

    val launchResidentList: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()
    val launchSummary: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()


    override fun onCreate() {
    }


    fun onAddSurvey(){
        if (userRepository.getLocality() != null){
            launchAddSurvey.postValue(Event(emptyMap()))
        }else{
            launchAddLocality.postValue(Event(emptyMap()))
        }


    }

    fun onChangeLocality(){
        launchAddLocality.postValue(Event(emptyMap()))
    }

    fun residentDidTapped(){
        launchResidentList.postValue(Event(emptyMap()))



    }

    fun summaryDidTapped(){
        launchSummary.postValue(Event(emptyMap()))
    }

}
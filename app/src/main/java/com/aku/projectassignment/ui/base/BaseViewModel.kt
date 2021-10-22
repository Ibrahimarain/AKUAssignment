package com.aku.projectassignment.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(
        private val compositeDisposable: CompositeDisposable
    ) : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    val messageStringId: MutableLiveData<Int> = MutableLiveData()
    val messageString: MutableLiveData<String> = MutableLiveData()

    abstract fun  onCreate()



}
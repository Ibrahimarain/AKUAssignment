package com.mindorks.bootcamp.instagram.ui.base

import androidx.lifecycle.MutableLiveData
import com.aku.projectassignment.ui.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable


abstract class BaseItemViewModel<T : Any>(
    compositeDisposable: CompositeDisposable,
) : BaseViewModel(compositeDisposable) {

    val data: MutableLiveData<T> = MutableLiveData()

    fun onManualCleared() = onCleared()

    fun updateData(data: T) {
        this.data.postValue(data)
    }
}
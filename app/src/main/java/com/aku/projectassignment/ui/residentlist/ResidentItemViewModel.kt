package com.aku.projectassignment.ui.residentlist

import android.util.Log
import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.aku.projectassignment.data.local.db.entity.ResidentEntity
import com.aku.projectassignment.utils.common.Resource
import com.mindorks.bootcamp.instagram.ui.base.BaseItemViewModel
import io.reactivex.disposables.CompositeDisposable
import java.util.logging.Logger
import javax.inject.Inject

class ResidentItemViewModel @Inject constructor(
    compositeDisposable: CompositeDisposable,
) : BaseItemViewModel<ResidentEntity>(compositeDisposable) {

    companion object {
        const val TAG = "DummyItemViewModel"
    }

    val name: LiveData<String> = Transformations.map(data) { it.name }
    val age: LiveData<Int> = Transformations.map(data) { it.ageInYears }
    val gender: LiveData<Int> = Transformations.map(data) { it.gender }

    fun onItemClick(position: Int) {
        messageString.postValue(Resource.success("onItemClick at $position of ${data.value?.name}").toString())
        Log.d(TAG, "onItemClick at $position")
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate called")
    }
}
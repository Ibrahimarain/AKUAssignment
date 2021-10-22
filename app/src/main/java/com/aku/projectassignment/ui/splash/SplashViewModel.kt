package com.aku.projectassignment.ui.splash

import androidx.lifecycle.MutableLiveData
import com.aku.projectassignment.data.repository.ResidentRepository
import com.aku.projectassignment.data.repository.UserRepository
import com.aku.projectassignment.ui.base.BaseViewModel
import com.aku.projectassignment.utils.common.Event
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit


class SplashViewModel(
    compositeDisposable: CompositeDisposable,
    private val userRepository: UserRepository
) : BaseViewModel(compositeDisposable) {

    // Event is used by the view model to tell the activity to launch another Activity
    // view model also provided the Bundle in the event that is needed for the Activity
    val launchHome: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()
    val launchLogin: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()

    override fun onCreate()  {

        CoroutineScope(Dispatchers.IO).launch {
            delay(TimeUnit.SECONDS.toMillis(3))
            withContext(Dispatchers.Main) {
                launchActivities()
            }
        }
    }

    private fun launchActivities (){

        // Empty map of key and serialized value is passed to Activity in Event that is needed by the other Activity
        if (userRepository.getCurrentUser() != null)
            launchHome.postValue(Event(emptyMap()))
        else
            launchLogin.postValue(Event(emptyMap()))
    }
}
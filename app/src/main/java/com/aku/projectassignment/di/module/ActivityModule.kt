package com.aku.projectassignment.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.aku.projectassignment.data.local.db.DatabaseService
import com.aku.projectassignment.data.repository.ResidentRepository
import com.aku.projectassignment.data.repository.UserRepository
import com.aku.projectassignment.di.ActivityContext
import com.aku.projectassignment.ui.base.BaseActivity
import com.aku.projectassignment.ui.home.HomeViewModel
import com.aku.projectassignment.ui.locality.LocalityViewModel
import com.aku.projectassignment.ui.login.LoginViewModel
import com.aku.projectassignment.ui.splash.SplashViewModel
import com.aku.projectassignment.ui.survey.AddResidentViewModel
import com.aku.projectassignment.utils.factory.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ActivityModule(private val activity : BaseActivity<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideResidentViewModel(compositeDisposable: CompositeDisposable,
                                 residentRepository: ResidentRepository, userRepository: UserRepository) : AddResidentViewModel{
        return ViewModelProviders.of(activity,
            ViewModelProviderFactory(AddResidentViewModel::class){
                AddResidentViewModel(compositeDisposable,residentRepository,userRepository)
        }).get(AddResidentViewModel::class.java)
    }

    @Provides
    fun providesSplashViewModel(compositeDisposable: CompositeDisposable,
                                 userRepository: UserRepository) : SplashViewModel{
        return ViewModelProviders.of(activity,
            ViewModelProviderFactory(SplashViewModel::class){
                SplashViewModel(compositeDisposable,userRepository)
            }).get(SplashViewModel::class.java)
    }


    @Provides
    fun provideLoginViewModel(
            compositeDisposable: CompositeDisposable,
            userRepository: UserRepository
    ): LoginViewModel = ViewModelProviders.of(
            activity, ViewModelProviderFactory(LoginViewModel::class) {
        LoginViewModel( compositeDisposable, userRepository)
    }).get(LoginViewModel::class.java)


    @Provides
    fun provideHomeViewModel(
            compositeDisposable: CompositeDisposable,
            userRepository: UserRepository
    ): HomeViewModel = ViewModelProviders.of(
            activity, ViewModelProviderFactory(HomeViewModel::class) {
        HomeViewModel( compositeDisposable, userRepository)
    }).get(HomeViewModel::class.java)

    @Provides
    fun provideLocalityViewModel(
            compositeDisposable: CompositeDisposable,
            userRepository: UserRepository
    ): LocalityViewModel = ViewModelProviders.of(
            activity, ViewModelProviderFactory(LocalityViewModel::class) {
        LocalityViewModel( compositeDisposable, userRepository)
    }).get(LocalityViewModel::class.java)


}
package com.aku.projectassignment.di.component

import android.content.Context
import com.aku.projectassignment.AKUApplication
import com.aku.projectassignment.data.local.db.DatabaseService
import com.aku.projectassignment.data.repository.ResidentRepository
import com.aku.projectassignment.data.repository.UserRepository
import com.aku.projectassignment.di.ApplicationContext
import com.aku.projectassignment.di.module.ApplicationModule
import com.google.gson.Gson
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject (application : AKUApplication)

    @ApplicationContext
    fun getContext() : Context

    fun getDatabaseService() : DatabaseService

    fun getCompositeDisposable() : CompositeDisposable

    fun getResidentRepository() : ResidentRepository

    fun getUserRepository(): UserRepository

    fun getGson(): Gson




}
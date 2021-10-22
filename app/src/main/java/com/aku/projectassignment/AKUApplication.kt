package com.aku.projectassignment

import android.app.Application
import android.util.Log
import com.aku.projectassignment.data.local.db.DatabaseService
import com.aku.projectassignment.data.local.db.entity.ResidentEntity
import com.aku.projectassignment.di.component.ApplicationComponent
import com.aku.projectassignment.di.component.DaggerApplicationComponent
import com.aku.projectassignment.di.module.ApplicationModule
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AKUApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var databaseService : DatabaseService

    @Inject
    lateinit var compositeDisposable: CompositeDisposable


    private val TAG = "AKUApplication"

    override fun onCreate() {
        super.onCreate()
        getDependencies()

    }


    private fun getDependencies(){
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()

        applicationComponent.inject(this)

    }


}
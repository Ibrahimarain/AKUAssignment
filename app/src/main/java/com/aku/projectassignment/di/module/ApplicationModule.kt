package com.aku.projectassignment.di.module

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aku.projectassignment.AKUApplication
import com.aku.projectassignment.data.local.db.DatabaseService
import com.aku.projectassignment.di.ApplicationContext
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class ApplicationModule(private val application : AKUApplication) {

    @Provides
    @ApplicationContext
    fun provideContext() : Context{
        return application
    }

    @Provides
    fun provideCompositeDisposable() : CompositeDisposable =  CompositeDisposable()

    @Provides
    fun provideGson() : Gson =  Gson()

    @Provides
    @Singleton
    fun provideDatabaseService() : DatabaseService {

        return Room.databaseBuilder(application,
            DatabaseService::class.java,
            "population_db").
             build()
    }


    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences =
            application.getSharedPreferences("bootcamp-instagram-project-prefs", Context.MODE_PRIVATE)


}
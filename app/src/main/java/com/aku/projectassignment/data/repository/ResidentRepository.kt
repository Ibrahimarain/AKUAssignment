package com.aku.projectassignment.data.repository

import com.aku.projectassignment.data.local.db.DatabaseService
import com.aku.projectassignment.data.local.db.entity.ResidentEntity
import com.aku.projectassignment.data.local.prefs.UserPreferences
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject

class ResidentRepository @Inject constructor
    (private val databaseService: DatabaseService,
     private val userPreferences: UserPreferences,
        private val gson: Gson) {

        fun addResident(residentToAdd : ResidentEntity) =
        databaseService.residentDao().addResident(residentToAdd)

        fun storeInitialData(residentToStore : ResidentEntity) =
        userPreferences.setInitialResident(gson.toJson(residentToStore))

        fun getInitialData() =
        gson.fromJson(userPreferences.getInitialResident(),ResidentEntity::class.java)



}
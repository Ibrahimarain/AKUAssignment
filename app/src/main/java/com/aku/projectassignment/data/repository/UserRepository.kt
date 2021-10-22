package com.aku.projectassignment.data.repository

import com.aku.projectassignment.data.local.db.DatabaseService
import com.aku.projectassignment.data.local.prefs.UserPreferences
import com.aku.projectassignment.data.model.Locality
import com.aku.projectassignment.data.model.User
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepository @Inject constructor(
        private val databaseService: DatabaseService,
        private val userPreferences: UserPreferences
) {

    fun saveCurrentUser(user: User) {
        userPreferences.setUserId(user.id)
        userPreferences.setUserName(user.name)
        userPreferences.setUserEmail(user.email)
        userPreferences.setAccessToken(user.accessToken)
    }

    fun removeCurrentUser() {
        userPreferences.removeUserId()
        userPreferences.removeUserName()
        userPreferences.removeUserEmail()
        userPreferences.removeAccessToken()
    }

    fun getCurrentUser(): User? {

        val userId = userPreferences.getUserId()
        val userName = userPreferences.getUserName()
        val userEmail = userPreferences.getUserEmail()
        val accessToken = userPreferences.getAccessToken()

        return if (userId !== null && userName != null && userEmail != null && accessToken != null)
            User(userId, userName, userEmail, accessToken)
        else
            null
    }


    fun saveLocality(locality: Locality) {
        userPreferences.setUserProvince(locality.province)
        userPreferences.setUserDistrict(locality.district)
        userPreferences.setUserTehsil(locality.tehsil)
    }

    fun getLocality(): Locality? {

        val province = userPreferences.getUserProvince()
        val district = userPreferences.getUserDistrict()
        val tehsil = userPreferences.getUserTehsil()

        return if (province !== 0 && district != 0 && tehsil != 0)
            Locality(province,district,tehsil)
        else
            null
    }


    //fun doUserLogin(email: String, password: String): Single<User> {}

}
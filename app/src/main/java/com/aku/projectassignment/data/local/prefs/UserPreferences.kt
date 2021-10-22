package com.aku.projectassignment.data.local.prefs

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferences @Inject constructor(private val prefs: SharedPreferences) {

    companion object {
        const val KEY_USER_ID = "PREF_KEY_USER_ID"
        const val KEY_USER_NAME = "PREF_KEY_USER_NAME"
        const val KEY_USER_EMAIL = "PREF_KEY_USER_EMAIL"
        const val KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"

        const val KEY_PROVINCE = "PREF_KEY_PROVINCE"
        const val KEY_DISTRICT = "PREF_KEY_DISTRICT"
        const val KEY_TEHSIL = "PREF_KEY_TEHSIL"

        const val KEY_INITIAL_RESIDENT = "PREF_KEY_INITIAL_RESIDENT"

    }

    fun getUserId(): String? =
        prefs.getString(KEY_USER_ID, null)

    fun setUserId(userId: String) =
        prefs.edit().putString(KEY_USER_ID, userId).apply()

    fun removeUserId() =
        prefs.edit().remove(KEY_USER_ID).apply()

    fun getUserName(): String? =
        prefs.getString(KEY_USER_NAME, null)

    fun setUserName(userName: String) =
        prefs.edit().putString(KEY_USER_NAME, userName).apply()

    fun removeUserName() =
        prefs.edit().remove(KEY_USER_NAME).apply()

    fun getUserEmail(): String? =
        prefs.getString(KEY_USER_EMAIL, null)

    fun setUserEmail(email: String) =
        prefs.edit().putString(KEY_USER_EMAIL, email).apply()

    fun removeUserEmail() =
        prefs.edit().remove(KEY_USER_EMAIL).apply()

    fun getAccessToken(): String? =
        prefs.getString(KEY_ACCESS_TOKEN, null)

    fun setAccessToken(token: String) =
        prefs.edit().putString(KEY_ACCESS_TOKEN, token).apply()

    fun removeAccessToken() =
        prefs.edit().remove(KEY_ACCESS_TOKEN).apply()

    fun getUserProvince(): Int =
            prefs.getInt(KEY_PROVINCE, 0)

    fun setUserProvince(userId: Int) =
            prefs.edit().putInt(KEY_PROVINCE, userId).apply()

    fun getUserDistrict(): Int =
            prefs.getInt(KEY_DISTRICT, 0)

    fun setUserDistrict(userId: Int) =
            prefs.edit().putInt(KEY_DISTRICT, userId).apply()

    fun getUserTehsil(): Int =
            prefs.getInt(KEY_TEHSIL, 0)

    fun setUserTehsil(userId: Int) =
            prefs.edit().putInt(KEY_TEHSIL, userId).apply()

    fun getInitialResident(): String? =
            prefs.getString(KEY_INITIAL_RESIDENT, null)

    fun setInitialResident(resident: String) =
            prefs.edit().putString(KEY_INITIAL_RESIDENT, resident).apply()

}
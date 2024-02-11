package com.example.hw_3_4.Data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.hw_3_4.ui.notifications.CONSTANTS

class Pref(context: Context) {

    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun getName(): String? {
        return pref.getString(NAME_SAVED, null)
    }

    fun saveName(name: String) {
        pref.edit().putString(NAME_SAVED, name).apply()
    }

    fun isShow(): Boolean {
        return pref.getBoolean(SHOWED_KEY, false)
    }


    fun onShowed() {
        pref.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    fun saveImage(image: String) {
        pref.edit().putString(IMAGE_SAVED, image).apply()
    }

    fun getImage(): String? {
        return pref.getString(IMAGE_SAVED, null)
    }



    class MySharedPreferences(val context: Context) {
        private val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(CONSTANTS.APP_DATA, Context.MODE_PRIVATE)

        fun setUserAuth(bool: Boolean) {
            sharedPreferences
                .edit()
                .putBoolean(CONSTANTS.USER_AUTHED, bool)
                .apply()
        }

        fun getUserAuthed(): Boolean? {
            return sharedPreferences.getBoolean(CONSTANTS.USER_AUTHED, false)
        }
        fun setOnboardingShown() {
            sharedPreferences
                .edit()
                .putBoolean(CONSTANTS.ONBOARDING_SHOWN, true)
                .apply()
        }

        fun getOnboardingShownStatus(): Boolean? {
            return sharedPreferences.getBoolean(CONSTANTS.ONBOARDING_SHOWN, false)
        }

        fun saveName(name: String) {
            sharedPreferences
                .edit()
                .putString(CONSTANTS.PROFILE_NAME, name)
                .apply()
        }

        fun getSavedName(): String? {
            val savedName = sharedPreferences.getString(CONSTANTS.PROFILE_NAME, "default")

            return if (savedName != "default") {
                savedName
            } else {
                null
            }
        }

        fun saveLogin(login: String) {
            sharedPreferences
                .edit()
                .putString(CONSTANTS.PROFILE_LOGIN, login)
                .apply()
        }

        fun getSavedLogin(): String? {
            val savedLogin = sharedPreferences.getString(CONSTANTS.PROFILE_LOGIN, "default")

            return if (savedLogin != "default") {
                savedLogin
            } else {
                null
            }
        }

        fun saveAvatar(url: String) {
            sharedPreferences
                .edit()
                .putString(CONSTANTS.PROFILE_AVATAR, url)
                .apply()
        }

        fun getSavedAvatar(): String? {
            val savedAvatar = sharedPreferences.getString(CONSTANTS.PROFILE_AVATAR, "default")

            return if (savedAvatar != "default") {
                savedAvatar
            } else {
                null
            }
        }
    }
    companion object {
        const val IMAGE_SAVED = "image.saved"
        const val NAME_SAVED = "name.saved"
        const val PREF_NAME = "pref.name"
        const val SHOWED_KEY = "showed.key"
    }

}
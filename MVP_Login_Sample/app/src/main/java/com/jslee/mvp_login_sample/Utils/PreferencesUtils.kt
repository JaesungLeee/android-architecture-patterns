package com.jslee.mvp_login_sample.Utils

import android.content.Context
import android.content.SharedPreferences


class PreferencesUtils(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFERENCES_NAME_LOGIN, Context.MODE_PRIVATE)

    var autoLoginStatus: Boolean
        get() = sharedPreferences.getBoolean(PREFERENCES_KEY_AUTO_LOGIN, false)
        set(value) {
            sharedPreferences.edit().apply {
                putBoolean(PREFERENCES_KEY_AUTO_LOGIN, value)
                apply()
            }
        }

    var userEmail: String
        get() = sharedPreferences.getString(PREFERENCES_KEY_USER_EMAIL, "").toString()
        set(value) {
            sharedPreferences.edit().apply{
                putString(PREFERENCES_KEY_USER_EMAIL, value)
                apply()
            }
        }

    var userPassword: String
        get() = sharedPreferences.getString(PREFERENCES_KEY_USER_PASSWORD, "").toString()
        set(value) {
            sharedPreferences.edit().apply{
                putString(PREFERENCES_KEY_USER_PASSWORD, value)
                apply()
            }
        }

    var userName: String
        get() = sharedPreferences.getString(PREFERENCES_KEY_USER_NAME, "").toString()
        set(value) {
            sharedPreferences.edit().apply{
                putString(PREFERENCES_KEY_USER_NAME, value)
                apply()
            }
        }


    companion object {
        private const val PREFERENCES_NAME_LOGIN = "PREFERENCES_NAME_LOGIN"
        private const val PREFERENCES_KEY_AUTO_LOGIN = "PREFERENCES_KEY_AUTO_LOGIN"
        private const val PREFERENCES_KEY_USER_EMAIL = "PREFERENCES_KEY_USER_EMAIL"
        private const val PREFERENCES_KEY_USER_PASSWORD = "PREFERENCES_KEY_USER_PASSWORD"
        private const val PREFERENCES_KEY_USER_NAME = "PREFERENCES_KEY_USER_NAME"
    }
}
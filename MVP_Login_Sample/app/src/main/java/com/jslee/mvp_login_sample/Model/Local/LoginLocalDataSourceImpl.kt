package com.jslee.mvp_login_sample.Model.Local

import com.jslee.mvp_login_sample.Utils.PreferencesUtils

class LoginLocalDataSourceImpl(private val preferencesUtils: PreferencesUtils): LoginLocalDataSource {
    override var autoLogin: Boolean
        get() = preferencesUtils.autoLoginStatus
        set(value) {
            preferencesUtils.autoLoginStatus = value
        }

    override var userEmail: String
        get() = preferencesUtils.userEmail
        set(value) {
            preferencesUtils.userEmail = value
        }

    override var userPassword: String
        get() = preferencesUtils.userPassword
        set(value) {
            preferencesUtils.userPassword = value
        }

    override var userName: String
        get() = preferencesUtils.userName
        set(value) {
            preferencesUtils.userName = value
        }
}
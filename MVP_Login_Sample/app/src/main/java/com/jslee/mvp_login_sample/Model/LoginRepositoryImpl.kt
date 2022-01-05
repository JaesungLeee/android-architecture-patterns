package com.jslee.mvp_login_sample.Model

import com.jslee.mvp_login_sample.Model.Local.LoginLocalDataSource

class LoginRepositoryImpl(private val loginLocalDataSource: LoginLocalDataSource): LoginRepository {
    override var autoLogin: Boolean
        get() = loginLocalDataSource.autoLogin
        set(value) {
            loginLocalDataSource.autoLogin = value
        }

    override var userEmail: String
        get() = loginLocalDataSource.userEmail
        set(value) {
            loginLocalDataSource.userEmail = value
        }

    override var userPassword: String
        get() = loginLocalDataSource.userPassword
        set(value) {
            loginLocalDataSource.userPassword = value
        }

    override var userName: String
        get() = loginLocalDataSource.userName
        set(value) {
            loginLocalDataSource.userName = value
        }
}
package com.jslee.mvp_login_sample.Model.Local

interface LoginLocalDataSource {
    var autoLogin: Boolean

    var userEmail: String

    var userPassword: String

    var userName: String
}
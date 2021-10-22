package com.jslee.mvp_login_sample.Model

interface LoginRepository {

    var autoLogin: Boolean

    var userEmail: String

    var userPassword: String

    var userName: String
}
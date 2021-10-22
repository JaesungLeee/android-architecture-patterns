package com.jslee.mvp_login_sample.Presenter.Login

interface LoginContract {

    interface View {

        fun onFieldEmpty()

        fun onEmailEmpty()

        fun onPasswordEmpty()

        fun onLoginFailed()

        fun moveToSignUp()

        fun moveToUserInfo()

        fun showProgressBar()

        fun hideProgressBar()

    }

    interface Presenter {

        fun bindView(view: LoginContract.View)

        fun dropView()

        fun requestLogin(email: String, password: String)
    }
}
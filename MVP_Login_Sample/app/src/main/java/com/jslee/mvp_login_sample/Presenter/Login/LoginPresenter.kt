package com.jslee.mvp_login_sample.Presenter.Login

import com.jslee.mvp_login_sample.Model.LoginRepository

class LoginPresenter(
    private var loginView: LoginContract.View?,
    private val loginRepository: LoginRepository
): LoginContract.Presenter {

    override fun bindView(view: LoginContract.View) {
        loginView = view
    }

    override fun dropView() {
        loginView = null
    }

    override fun requestLogin(email: String, password: String) {
        if (email.isEmpty() && password.isEmpty()) loginView?.onFieldEmpty()
        else if (email.isEmpty()) loginView?.onEmailEmpty()
        else if (password.isEmpty()) loginView?.onPasswordEmpty()
        else if (loginRepository.userEmail != email || loginRepository.userPassword != password) loginView?.onLoginFailed()
        else {
            loginRepository.autoLogin = true
            loginView?.moveToUserInfo()
        }
    }
}
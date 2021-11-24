package com.jslee.mvp_login_sample.Presenter.Info

import com.jslee.mvp_login_sample.Model.LoginRepository

class InfoPresenter(
    private var infoView: InfoContract.View?,
    private val repository: LoginRepository
): InfoContract.Presenter {
    override fun bindView(view: InfoContract.View) {
        infoView = view
    }

    override fun dropView() {
        infoView = null
    }

    override fun logout() {
        repository.autoLogin = false

        infoView?.moveToLogin()
    }

    override fun fetchInfo() {
        val email = repository.userEmail
        val password = repository.userPassword
        val userName = repository.userName

        infoView?.displayInfo(email, password, userName)
    }
}
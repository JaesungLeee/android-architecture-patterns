package com.jslee.mvp_login_sample.Presenter.SignUp

import com.jslee.mvp_login_sample.Model.LoginRepository

class SignUpPresenter(
    private var signUpView: SignUpContract.View?,
    private val repository: LoginRepository
): SignUpContract.Presenter {
    override fun bindView(view: SignUpContract.View) {
        signUpView = view
    }

    override fun dropView() {
        signUpView = null
    }

    override fun registerInfo(email: String, password: String, userName: String) {
        if (email.isEmpty() && password.isEmpty() && userName.isEmpty()) signUpView?.onFieldEmpty()
        else if (email.isEmpty()) signUpView?.onEmailEmpty()
        else if (password.isEmpty()) signUpView?.onPasswordEmpty()
        else if (userName.isEmpty()) signUpView?.onUserNameEmpty()
        else {
            repository.apply {
                this.autoLogin = true
                this.userEmail = email
                this.userPassword = password
                this.userName = userName
            }

            signUpView?.moveToInfoPage()
        }
    }
}
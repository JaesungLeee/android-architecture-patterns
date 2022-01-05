package com.jslee.mvp_login_sample.Presenter.Info

interface InfoContract {

    interface View {

        fun displayInfo(email: String, password: String, userName: String)

        fun moveToLogin()
    }

    interface Presenter {
        fun bindView(view: InfoContract.View)

        fun dropView()

        fun fetchInfo()

        fun logout()
    }
}
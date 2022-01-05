package com.jslee.mvp_login_sample.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jslee.mvp_login_sample.Model.Local.LoginLocalDataSourceImpl
import com.jslee.mvp_login_sample.Model.LoginRepositoryImpl
import com.jslee.mvp_login_sample.Presenter.Info.InfoContract
import com.jslee.mvp_login_sample.Presenter.Info.InfoPresenter
import com.jslee.mvp_login_sample.Utils.PreferencesUtils
import com.jslee.mvp_login_sample.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity(), InfoContract.View {

    private lateinit var binding: ActivityInfoBinding
    private lateinit var infoPresenter: InfoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()
        bindView()
    }

    private fun initPresenter() {
        val preferencesUtils = PreferencesUtils(this)
        val localDataSource = LoginLocalDataSourceImpl(preferencesUtils)
        val repository = LoginRepositoryImpl(localDataSource)

        infoPresenter = InfoPresenter(this, repository)
        infoPresenter.bindView(this)
        infoPresenter.fetchInfo()
    }

    private fun bindView() {
        binding.logoutButton.setOnClickListener {
            Toast.makeText(this, "로그아웃 성공", Toast.LENGTH_LONG).show()

            infoPresenter.logout()
        }
    }

    override fun displayInfo(email: String, password: String, userName: String) {
        binding.userEmailTextView.text = email
        binding.userPasswordTextView.text = password
        binding.userNameTextView.text = userName
    }

    override fun moveToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
package com.jslee.mvp_login_sample.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jslee.mvp_login_sample.Model.Local.LoginLocalDataSourceImpl
import com.jslee.mvp_login_sample.Model.LoginRepositoryImpl
import com.jslee.mvp_login_sample.Presenter.Login.LoginContract
import com.jslee.mvp_login_sample.Presenter.Login.LoginPresenter
import com.jslee.mvp_login_sample.Utils.PreferencesUtils
import com.jslee.mvp_login_sample.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()
        bindView()
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.dropView()
    }

    private fun initPresenter() {
        val preferencesUtils = PreferencesUtils(this)
        val loginLocalDataSource = LoginLocalDataSourceImpl(preferencesUtils)
        val loginRepository = LoginRepositoryImpl(loginLocalDataSource)

        loginPresenter = LoginPresenter(this, loginRepository)
        loginPresenter.bindView(this)
    }

    private fun bindView() {
        binding.loginButton.setOnClickListener {
            val userEmail = binding.emailEditText.text.toString().trim()
            val userPassword = binding.passwordEditText.text.toString().trim()

            // Presenter에 전달
            loginPresenter.requestLogin(userEmail, userPassword)
        }

        binding.signupButton.setOnClickListener {
            moveToSignUp()
        }
    }

    override fun onFieldEmpty() {
        Toast.makeText(this, "이메일과 패스워드 모두 입력해주세요.", Toast.LENGTH_LONG).show()
    }

    override fun onEmailEmpty() {
        Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_LONG).show()
    }

    override fun onPasswordEmpty() {
        Toast.makeText(this, "패스워드를 입력해주세요", Toast.LENGTH_LONG).show()
    }

    override fun onLoginFailed() {
        Toast.makeText(this, "로그인에 실패하였습니다.", Toast.LENGTH_LONG).show()
    }

    override fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    override fun moveToSignUp() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    override fun moveToUserInfo() {
        Toast.makeText(this, "로그인 성공", Toast.LENGTH_LONG).show()

        val intent = Intent(this, InfoActivity::class.java)
        startActivity(intent)
        finish()
    }

}
package com.jslee.mvp_login_sample.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jslee.mvp_login_sample.Model.Local.LoginLocalDataSource
import com.jslee.mvp_login_sample.Model.Local.LoginLocalDataSourceImpl
import com.jslee.mvp_login_sample.Model.LoginRepositoryImpl
import com.jslee.mvp_login_sample.Presenter.SignUp.SignUpContract
import com.jslee.mvp_login_sample.Presenter.SignUp.SignUpPresenter
import com.jslee.mvp_login_sample.Utils.PreferencesUtils
import com.jslee.mvp_login_sample.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity(), SignUpContract.View {

    private lateinit var binding: ActivitySignUpBinding

    private lateinit var signUpPresenter: SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()
        bindView()
    }

    override fun onDestroy() {
        super.onDestroy()
        signUpPresenter.dropView()
    }

    private fun initPresenter() {
        val preferencesUtils = PreferencesUtils(this)
        val localDataSource = LoginLocalDataSourceImpl(preferencesUtils)
        val repository = LoginRepositoryImpl(localDataSource)

        signUpPresenter = SignUpPresenter(this, repository)
        signUpPresenter.bindView(this)
    }

    private fun bindView() {
        binding.signupRegisterButton.setOnClickListener {
            val userEmail = binding.signupEmailEditText.text.toString().trim()
            val userPassword = binding.signupPasswordEditText.text.toString().trim()
            val userName = binding.signupUserNameEditText.text.toString().trim()

            signUpPresenter.registerInfo(userEmail, userPassword, userName)
        }
    }

    override fun onFieldEmpty() {
        Toast.makeText(this, "입력 필드를 모두 채워주세요", Toast.LENGTH_LONG).show()
    }

    override fun onEmailEmpty() {
        Toast.makeText(this, "이메일을 입력하세요", Toast.LENGTH_LONG).show()
    }

    override fun onPasswordEmpty() {
        Toast.makeText(this, "패스워드를 입력하세요", Toast.LENGTH_LONG).show()
    }

    override fun onUserNameEmpty() {
        Toast.makeText(this, "이름을 입력하세요", Toast.LENGTH_LONG).show()
    }

    override fun moveToInfoPage() {
        Toast.makeText(this, "로그인 성공", Toast.LENGTH_LONG).show()

        val intent = Intent(this, InfoActivity::class.java)
        startActivity(intent)
        finish()
    }
}
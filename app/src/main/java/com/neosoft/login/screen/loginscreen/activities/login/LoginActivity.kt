package com.neosoft.login.screen.loginscreen.activities.login

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import com.neosoft.login.screen.loginscreen.R
import com.neosoft.login.screen.loginscreen.activities.base.BaseActivity
import com.neosoft.login.screen.loginscreen.databinding.ActivityLoginBinding
import com.neosoft.login.screen.loginscreen.responses.LoginResponse
import com.neosoft.login.screen.loginscreen.utils.Utils

class LoginActivity : BaseActivity<ActivityLoginBinding>(), LoginContract.View {
    override fun showLoading() {
        binding.model?.loading = true
    }

    override fun hideLoading() {
        binding.model?.loading = false
    }

    override fun onLoginSuccess(response: LoginResponse) {
        showMessage(response.userMsg)
    }

    override fun onLoginFailure() {
        showMessage("Response Unsuccessful")
    }

    private lateinit var btnLogin: Button
    private lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    private lateinit var tvLogin: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var email: String
    private lateinit var pass: String
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        binding.model = LoginBindingModel()
    }

    override fun initViews() {
        presenter = LoginPresenter()
        btnLogin = findViewById(R.id.btn_login)
        tvLogin = findViewById(R.id.tv_login)
        etEmail = findViewById(R.id.et_email)
        etPass = findViewById(R.id.et_password)
        progressBar = findViewById(R.id.login_progress_bar)
    }

    override fun getContentLayout(): Int {
        return R.layout.activity_login
    }

    override fun intentData() {

    }

    override fun listeners() {
        btnLogin.setOnClickListener {

            email = etEmail.text.toString().trim()
            pass = etPass.text.toString().trim()

            if ((TextUtils.isEmpty(email))) showErrorForEmptyField(etEmail)
            else if ((TextUtils.isEmpty(pass))) showErrorForEmptyField(etPass)
            else if (!Utils.getInstance().doEmailValidation(email))
                showErrorForInvalidField(etEmail)
            else if (!Utils.getInstance().doPasswordValidation(pass))
                showErrorForInvalidField(etPass)
            else {
                if (Utils.getInstance().isInternetConnected(this)) {
                    presenter.doLogin(email, pass)
                } else {
                    showMessage("No Internet Connection Available")
                }

            }

        }

    }

}

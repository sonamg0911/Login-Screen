package com.neosoft.login.screen.loginscreen.activities.login

import android.os.Bundle
import com.neosoft.login.screen.loginscreen.R
import com.neosoft.login.screen.loginscreen.activities.base.BaseActivity
import com.neosoft.login.screen.loginscreen.databinding.ActivityLoginBinding
import com.neosoft.login.screen.loginscreen.responses.LoginResponse
import com.neosoft.login.screen.loginscreen.responses.UserData
import com.neosoft.login.screen.loginscreen.utils.Navigator
import com.neosoft.login.screen.loginscreen.utils.Utils

class LoginActivity : BaseActivity<ActivityLoginBinding>(), LoginContract.View {

    override fun navigateToHome(data: UserData) { Navigator.getInstance().navigateToHome(this,data) }

    override fun showInvalidEmailFieldError() {showErrorForInvalidField(binding.etEmail)}

    override fun showInvalidPasswordFieldError() {showErrorForInvalidField(binding.etPassword)}

    override fun showEmptyEmailFieldError() {showErrorForEmptyField(binding.etEmail) }

    override fun showEmptyPasswordFieldError() { showErrorForEmptyField(binding.etPassword)}

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

    private lateinit var email: String
    private lateinit var pass: String
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        binding.model = LoginBindingModel()
        binding.activity = this
    }

    override fun initViews() {
        presenter = LoginPresenter()
    }

    override fun getContentLayout(): Int {
        return R.layout.activity_login
    }

    override fun intentData() {

    }

    override fun listeners() {

    }

    fun onLoginClicked(){
        email = binding.etEmail.text.toString().trim()
        pass = binding.etPassword.text.toString().trim()
        if (Utils.getInstance().isInternetConnected(this)) {
            presenter.doLogin(email, pass)
        } else {
            showMessage("No Internet Connection Available")
        }
    }

}

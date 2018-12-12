package com.neosoft.login.screen.loginscreen.activities.login

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.neosoft.login.screen.loginscreen.R
import com.neosoft.login.screen.loginscreen.utils.Utils
import com.neosoft.login.screen.loginscreen.activities.base.BaseActivity
import com.neosoft.login.screen.loginscreen.responses.LoginResponse
import com.neosoft.login.screen.loginscreen.utils.Navigator

class LoginActivity : BaseActivity(),LoginContract.View{
    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun onSuccess(response: LoginResponse) {
        Navigator.getInstance()
                .navigateToHome(this,response.data)

    }

    override fun onFailure() {
        showMessage("Response Unsuccessful")
    }

    private lateinit var btnLogin:Button
    private lateinit var etEmail:EditText
    private lateinit var etPass:EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var email:String
    private lateinit var pass:String
    private lateinit var presenter:LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
    }

    override fun initViews() {
        presenter=LoginPresenter()
        btnLogin=findViewById(R.id.btn_login)
        etEmail=findViewById(R.id.et_email)
        etPass=findViewById(R.id.et_password)
        progressBar=findViewById(R.id.login_progress_bar)
    }

    override fun getContentLayout(): Int {
        return R.layout.activity_login
    }

    override fun intentData() {

    }

    override fun listeners() {
        btnLogin.setOnClickListener {

            email=etEmail.text.toString().trim()
            pass=etPass.text.toString().trim()

            if((TextUtils.isEmpty(email))) showErrorForEmptyField(etEmail)
            else if((TextUtils.isEmpty(pass))) showErrorForEmptyField(etPass)
            else if(!Utils.getInstance().doEmailValidation(email))
                showErrorForInvalidField(etEmail)
            else if(!Utils.getInstance().doPasswordValidation(pass))
                showErrorForInvalidField(etPass)
            else {
                if(Utils.getInstance().isInternetConnected(this))
                {
                    presenter.doLogin(email,pass)
                    showLoading()
                }else{
                    showMessage("No Internet Connection Available")
                }

            }

        }

    }

}

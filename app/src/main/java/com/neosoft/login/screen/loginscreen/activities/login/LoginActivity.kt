package com.neosoft.login.screen.loginscreen.activities.login

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.neosoft.login.screen.loginscreen.R
import com.neosoft.login.screen.loginscreen.Utils
import com.neosoft.login.screen.loginscreen.activities.base.BaseActivity

class LoginActivity : BaseActivity(),LoginContract.View{
    override fun showLoading(visible: Boolean) {
        if(visible)progressBar.visibility = View.VISIBLE
        else progressBar.visibility = View.GONE
    }

    lateinit var btnLogin:Button
    lateinit var etEmail:EditText
    lateinit var etPass:EditText
    lateinit var progressBar: ProgressBar
    lateinit var email:String
    lateinit var pass:String
    var presenter=LoginPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
    }

    override fun initViews() {
        btnLogin=findViewById(R.id.btn_login)
        etEmail=findViewById(R.id.et_email)
        etPass=findViewById(R.id.et_password)
        progressBar=findViewById(R.id.login_progress_bar)
    }

    override fun getContentLayout(): Int {
        return R.layout.activity_login
    }

    override fun listeners() {
        btnLogin.setOnClickListener {

            if(!(TextUtils.isEmpty(etEmail.text.toString())))
                email=etEmail.text.toString().trim()
            else
                showErrorForEmptyField(etEmail)

            if(!(TextUtils.isEmpty(etPass.text.toString())))
                pass=etPass.text.toString().trim()
            else
                showErrorForEmptyField(etPass)

            if(!Utils.getInstance().doEmailValidation(email))
                showErrorForInvalidField(etEmail)
            else if(!Utils.getInstance().doPasswordValidation(pass))
                showErrorForInvalidField(etPass)
            else
            {
                presenter.doLogin(email,pass)
                showLoading(true)
            }


        }

    }

}

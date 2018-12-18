package com.neosoft.login.screen.loginscreen.activities.login

import com.neosoft.login.screen.loginscreen.activities.base.BaseContract
import com.neosoft.login.screen.loginscreen.responses.LoginResponse

interface LoginContract:BaseContract{

    interface View:BaseContract.View{
        fun showLoading()
        fun hideLoading()
        fun showEmptyEmailFieldError()
        fun showEmptyPasswordFieldError()
        fun showInvalidEmailFieldError()
        fun showInvalidPasswordFieldError()
        fun onLoginSuccess(response: LoginResponse)
        fun onLoginFailure()
    }

    interface Presenter{
        fun validate(email:String,password: String):Boolean
        fun doLogin(email:String,password:String)
    }
}
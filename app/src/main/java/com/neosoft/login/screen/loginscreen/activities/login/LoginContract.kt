package com.neosoft.login.screen.loginscreen.activities.login

import com.neosoft.login.screen.loginscreen.activities.base.BaseContract
import com.neosoft.login.screen.loginscreen.responses.LoginResponse
import com.neosoft.login.screen.loginscreen.responses.UserData

interface LoginContract{

    interface View:BaseContract.View{
        fun showLoading()
        fun hideLoading()
        fun showEmptyEmailFieldError()
        fun showEmptyPasswordFieldError()
        fun showInvalidEmailFieldError()
        fun showInvalidPasswordFieldError()
        fun onLoginSuccess(response: LoginResponse)
        fun onLoginFailure()
        fun navigateToHome(data: UserData)
    }

    interface Presenter{
        fun validate(email:String,password: String):Boolean
        fun doLogin(email:String,password:String)
        fun getCalendarList()
    }
}
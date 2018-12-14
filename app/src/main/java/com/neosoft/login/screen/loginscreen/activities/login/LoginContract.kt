package com.neosoft.login.screen.loginscreen.activities.login

import com.neosoft.login.screen.loginscreen.activities.base.BaseContract
import com.neosoft.login.screen.loginscreen.responses.LoginResponse

interface LoginContract:BaseContract{

    interface View:BaseContract.View{
        fun showLoading()
        fun hideLoading()
        fun onLoginSuccess(response: LoginResponse)
        fun onLoginFailure()
    }

    interface Presenter{
        fun doLogin(email:String,password:String)
    }
}
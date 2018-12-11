package com.neosoft.login.screen.loginscreen.activities.login

import com.neosoft.login.screen.loginscreen.activities.base.BaseContract

interface LoginContract:BaseContract{

    interface View:BaseContract.View{
        fun showLoading(visible: Boolean)
    }

    interface Presenter{
        fun doLogin(email:String,password:String)
    }
}
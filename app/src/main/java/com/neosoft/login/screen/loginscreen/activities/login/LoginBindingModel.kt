package com.neosoft.login.screen.loginscreen.activities.login

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.neosoft.login.screen.loginscreen.BR

class LoginBindingModel:BaseObservable(){

    private var email: String? = null
    private var password:String? = null

    @Bindable
    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
        notifyPropertyChanged(BR.email)
    }

    @Bindable
    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
        notifyPropertyChanged(BR.password)
    }



}
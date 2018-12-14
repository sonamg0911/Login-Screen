package com.neosoft.login.screen.loginscreen.activities.login

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.neosoft.login.screen.loginscreen.BR
import kotlin.properties.Delegates

/*class LoginBindingModel:BaseObservable(){

    private var email: String? = null
    private var password:String? = null
    private var loading:Boolean = false

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

    @Bindable
    fun isLoading(): Boolean {
        return loading
    }

    fun setLoading(loading:Boolean) {
        this.loading = loading
        notifyPropertyChanged(BR.loading)
    }

}*/

class LoginBindingModel:BaseObservable(){

    @get:Bindable var email: String by Delegates.observable("") { prop, old, new ->
        notifyPropertyChanged(BR.email)
    }

    @get:Bindable var password: String by Delegates.observable("") { prop, old, new ->
            notifyPropertyChanged(BR.password) }

    @get:Bindable var loading:Boolean by Delegates.observable(false) { prop, old, new ->
        notifyPropertyChanged(BR.loading)
    }

}

package com.neosoft.login.screen.loginscreen.activities.login

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.neosoft.login.screen.loginscreen.BR
import kotlin.properties.Delegates

class LoginBindingModel:BaseObservable(){

    @get:Bindable var email: String by Delegates.observable("") { prop, old, new ->
        notifyPropertyChanged(BR.email)
    }

    @get:Bindable var password: String by Delegates.observable("") { prop, old, new ->
        notifyPropertyChanged(BR.password) }

    @get:Bindable var loading: Boolean by Delegates.observable(false) { prop, old, new ->
        notifyPropertyChanged(BR.loading)
    }

}

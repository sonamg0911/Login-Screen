package com.neosoft.login.screen.loginscreen.activities.home

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.neosoft.login.screen.loginscreen.BR
import kotlin.properties.Delegates

class HomeBindingModel:BaseObservable(){

    @get:Bindable
    var firstName: String by Delegates.observable("") { prop, old, new ->
        notifyPropertyChanged(BR.firstName)
    }

    @get:Bindable
    var lastName: String by Delegates.observable("") { prop, old, new ->
        notifyPropertyChanged(BR.lastName)
    }

    @get:Bindable
    var phoneNo: String by Delegates.observable("") { prop, old, new ->
        notifyPropertyChanged(BR.phoneNo)
    }

    @get:Bindable
    var modified: String by Delegates.observable("") { prop, old, new ->
        notifyPropertyChanged(BR.modified)
    }

    @get:Bindable
    var accessToken: String by Delegates.observable("") { prop, old, new ->
        notifyPropertyChanged(BR.accessToken)
    }


}
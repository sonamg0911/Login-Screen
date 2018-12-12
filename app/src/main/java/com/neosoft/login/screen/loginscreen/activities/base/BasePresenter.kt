package com.neosoft.login.screen.loginscreen.activities.base

import com.neosoft.login.screen.loginscreen.network.ApiService

open class BasePresenter<V>{

    var view: V? = null
    protected var apiClient = ApiService.create()


    fun attachView(view: V) {
        this.view=view
    }

    fun detachView() {
        this.view=null
    }

}
package com.neosoft.login.screen.loginscreen.activities.base

import com.neosoft.login.screen.loginscreen.network.ApiService

open class BasePresenter<V>{

    protected val apiClient = ApiService.create()
    var view: V? = null

    fun attachView(view: V) {
        this.view=view
    }

    fun detachView() {
        this.view=null
    }

}
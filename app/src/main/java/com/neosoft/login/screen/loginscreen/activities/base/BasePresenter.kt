package com.neosoft.login.screen.loginscreen.activities.base

import com.neosoft.login.screen.loginscreen.network.ApiService
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<V>{

    var view: V? = null
    protected var apiClient = ApiService.create()
    protected var compositeDisposable = CompositeDisposable()

    fun attachView(view: V) {
        this.view=view
    }

    fun detachView() {
        this.view=null
    }

    fun disposeSubscription(){
        if(!compositeDisposable.isDisposed)
        compositeDisposable.dispose()
    }
}
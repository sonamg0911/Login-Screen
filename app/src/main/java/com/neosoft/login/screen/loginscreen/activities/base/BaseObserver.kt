package com.neosoft.login.screen.loginscreen.activities.base

import io.reactivex.Observer
import org.greenrobot.eventbus.EventBus

abstract class BaseObserver<T>:Observer<T>{

    override fun onError(e: Throwable){
        e.printStackTrace()
        EventBus.getDefault().post(e)
    }

}

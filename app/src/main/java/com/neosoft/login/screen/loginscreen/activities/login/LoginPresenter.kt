package com.neosoft.login.screen.loginscreen.activities.login

import com.neosoft.login.screen.loginscreen.activities.base.BasePresenter
import com.neosoft.login.screen.loginscreen.network.ApiManager
import com.neosoft.login.screen.loginscreen.responses.LoginResponse
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver

class LoginPresenter:BasePresenter<LoginContract.View>(),LoginContract.Presenter{

    override fun doLogin(email:String,password:String) {
        view?.showLoading()
        ApiManager.getInstance()
                .doLogin(email,password)
                .subscribe(object : Observer<LoginResponse>{
                    override fun onSubscribe(d: Disposable) {}

                    override fun onComplete() {}

                    override fun onNext(response : LoginResponse) {
                        view?.hideLoading()
                        if(response.status == 200){
                            view?.onLoginSuccess(response)
                        }
                        else view?.onLoginFailure()
                    }

                    override fun onError(e: Throwable) {
                        view?.hideLoading()
                        view?.showMessage("onFailureCalled")
                    }

        })

    }
}
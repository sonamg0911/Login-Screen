package com.neosoft.login.screen.loginscreen.activities.login

import com.neosoft.login.screen.loginscreen.activities.base.BasePresenter
import com.neosoft.login.screen.loginscreen.network.ApiManager
import com.neosoft.login.screen.loginscreen.responses.LoginResponse
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class LoginPresenter:BasePresenter<LoginContract.View>(),LoginContract.Presenter{

    override fun doLogin(email:String,password:String) {
        view?.showLoading()
        ApiManager.getInstance()
                .getLoginObservable(email,password)
                .subscribe(object : Observer<LoginResponse>{
                    override fun onSubscribe(d: Disposable) {
                        compositeDisposable.add(d)
                    }

                    override fun onComplete() {
                    }

                    override fun onNext(response : LoginResponse) {
                        view?.hideLoading()
                        if(response.status == 200){
                            view?.onLoginSuccess(response)
                        }
                        else view?.onLoginFailure()
                    }

                    override fun onError(e: Throwable) {
                        view?.hideLoading()
                        view?.showMessage(e.message!!)
                    }

        })
    }
}
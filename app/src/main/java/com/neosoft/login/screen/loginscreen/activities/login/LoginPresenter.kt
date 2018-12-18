package com.neosoft.login.screen.loginscreen.activities.login

import android.text.TextUtils
import com.neosoft.login.screen.loginscreen.R
import com.neosoft.login.screen.loginscreen.activities.base.BaseObserver
import com.neosoft.login.screen.loginscreen.activities.base.BasePresenter
import com.neosoft.login.screen.loginscreen.network.ApiManager
import com.neosoft.login.screen.loginscreen.responses.LoginResponse
import com.neosoft.login.screen.loginscreen.utils.Utils
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.*

class LoginPresenter:BasePresenter<LoginContract.View>(),LoginContract.Presenter{

    override fun validate(email: String, password: String):Boolean {

        return if ((TextUtils.isEmpty(email))) {
            view?.showEmptyEmailFieldError()
            false
        }
        else if ((TextUtils.isEmpty(password))) {
            view?.showEmptyPasswordFieldError()
            false
        }
        else if (!Utils.getInstance().doEmailValidation(email)) {
            view?.showInvalidEmailFieldError()
            false
        }
        else if (!Utils.getInstance().doPasswordValidation(password)) {
            view?.showInvalidPasswordFieldError()
            false
        }
        else {
            true
        }
    }

    override fun doLogin(email:String,password:String) {
        if (validate(email, password)) {
            view?.showLoading()
            ApiManager.getInstance()
                    .getLoginObservable(email, password)
                    .subscribe(object : BaseObserver<LoginResponse>() {
                        override fun onSubscribe(d: Disposable) {
                            compositeDisposable.add(d)
                        }

                        override fun onComplete() {
                        }

                        override fun onNext(response: LoginResponse) {
                            view?.hideLoading()
                            if (response.status == 200) {
                                view?.onLoginSuccess(response)
                                Thread(Runnable {
                                    view?.getUserDataDao()?.insertAll(response.data)
                                    return@Runnable}).start()
                            } else view?.onLoginFailure()

                        }

                        override fun onError(e: Throwable) {
                            view?.hideLoading()
                            view?.showMessage(e.message!!)
                        }
                    })
        }else{

        }
    }


}
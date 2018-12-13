package com.neosoft.login.screen.loginscreen.activities.login

import com.neosoft.login.screen.loginscreen.activities.base.BasePresenter
import com.neosoft.login.screen.loginscreen.responses.LoginResponse
import retrofit2.Call
import retrofit2.Response

class LoginPresenter:BasePresenter<LoginContract.View>(),LoginContract.Presenter{

    override fun doLogin(email:String,password:String) {
        view?.showLoading()
        apiClient.login(email,password).enqueue(object: retrofit2.Callback<LoginResponse>{

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view?.hideLoading()
                view?.showMessage("onFailureCalled")
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                view?.hideLoading()
                if(response.isSuccessful){
                    view?.showMessage(response.body()?.userMsg!!)
                    view?.onSuccess(response.body()!!)
                }
                else view?.onFailure()

            }
        })

    }
}
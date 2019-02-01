package com.neosoft.login.screen.loginscreen.network

import com.neosoft.login.screen.loginscreen.responses.CalendarListResponse
import com.neosoft.login.screen.loginscreen.responses.LoginResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiManager private constructor(){

    private val apiClient = ApiService.create()
    private val googleCalendarApiClient = GoogleCalendarService.create()

    companion object {

        private val apiManager:ApiManager = ApiManager()


        @Synchronized
        fun getInstance():ApiManager{
            return apiManager
        }
    }

    fun getLoginObservable(email:String, password:String):Observable<LoginResponse>{

        return apiClient.login(email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getCalendarListObservable():Observable<CalendarListResponse>{

        return googleCalendarApiClient.getCalendarList("sonams0308@gmail.com")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }

}
package com.neosoft.login.screen.loginscreen.utils

import android.content.Context
import android.content.Intent
import com.neosoft.login.screen.loginscreen.responses.UserData

class Navigator private constructor(){

    //Using Navigator as Singleton
    companion object {
        private val navigator = Navigator()

        @Synchronized
        fun getInstance():Navigator{
            return navigator
        }
    }

    lateinit var intent: Intent

    fun navigateToHome(context: Context,data:UserData){

    }





}
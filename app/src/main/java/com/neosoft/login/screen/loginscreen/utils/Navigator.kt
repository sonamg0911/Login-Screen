package com.neosoft.login.screen.loginscreen.utils

import android.content.Context
import android.content.Intent
import com.neosoft.login.screen.loginscreen.responses.LoginData

class Navigator private constructor(){

    //Using Navigator as Singleton
    companion object {
        private val navigator = Navigator()

        fun getInstance():Navigator{
            return navigator
        }
    }

    lateinit var intent: Intent

    fun navigateToHome(context: Context,data:LoginData){
        intent=Intent(context, HomeActivity::class.java)
        intent.putExtra(FIRST_NAME,data.firstName)
        intent.putExtra(LAST_NAME,data.lastName)
        intent.putExtra(EMAIL,data.email)
        intent.putExtra(PHONENO,data.phoneNo)
        context.startActivity(intent)
    }





}
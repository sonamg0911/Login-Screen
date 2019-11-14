package com.neosoft.login.screen.loginscreen.utils

import android.content.Context
import android.content.Intent
import com.neosoft.login.screen.loginscreen.activities.home.HomeActivity
import com.neosoft.login.screen.loginscreen.responses.UserData

//Use object Navigator instead
//object in kotlin work same as singleton in java
class Navigator private constructor(){

    //Using Navigator as Singleton
    companion object {
        private val navigator = Navigator()

        @Synchronized
        fun getInstance():Navigator{
            return navigator
        }
    }

    private lateinit var intent: Intent

    fun navigateToHome(context: Context,data: UserData){
        intent = Intent(context,HomeActivity::class.java)
        intent.putExtra(ID,data.id)
        context.startActivity(intent)

    }

}
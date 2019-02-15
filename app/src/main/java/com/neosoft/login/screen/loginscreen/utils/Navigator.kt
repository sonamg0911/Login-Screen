package com.neosoft.login.screen.loginscreen.utils

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import com.neosoft.login.screen.loginscreen.activities.AddTaskActivity
import com.neosoft.login.screen.loginscreen.activities.BarcodeActivity
import com.neosoft.login.screen.loginscreen.activities.CustomerSearchActivity
import com.neosoft.login.screen.loginscreen.activities.ReviewerModelActivity
import com.neosoft.login.screen.loginscreen.activities.home.HomeActivity
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

    private lateinit var intent: Intent

    fun navigateToHome(context: Context,data: UserData){
        intent = Intent(context,HomeActivity::class.java)
        intent.putExtra(ID,data.id)
        context.startActivity(intent)

    }

    fun navigateToHome(context: Context){
        intent = Intent(context,ReviewerModelActivity::class.java)
        context.startActivity(intent)

    }





}
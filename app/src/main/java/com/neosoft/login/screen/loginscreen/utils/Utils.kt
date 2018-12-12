package com.neosoft.login.screen.loginscreen.utils

import android.content.Context
import android.net.ConnectivityManager
import android.util.Patterns
import java.util.regex.Pattern


class Utils private constructor(){

    //Using Utils as Singleton
    companion object {
        private var utils: Utils = Utils()

        fun getInstance(): Utils {
            return utils
        }
    }

    fun doEmailValidation(email:String):Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun doPasswordValidation(pass:String):Boolean{
        val passPattern = "((?=.*\\d)(?=.*[a-z]).{6,20})"  //number and small letter is compulsary required in password
        return Pattern.compile(passPattern).matcher(pass).matches()
    }

    fun isInternetConnected(context: Context):Boolean{
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = cm.activeNetworkInfo
        return activeNetworkInfo !=null && activeNetworkInfo.isConnected
    }


}
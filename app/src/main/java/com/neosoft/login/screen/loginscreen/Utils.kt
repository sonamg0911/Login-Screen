package com.neosoft.login.screen.loginscreen

import android.util.Patterns
import java.util.regex.Pattern

class Utils private constructor(){

    companion object {
        private var utils:Utils = Utils()


        fun getInstance():Utils{
            return utils
        }
    }


    fun doEmailValidation(email:String):Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun doPasswordValidation(pass:String):Boolean{

        var passPattern = "((?=.*\\d)(?=.*[a-z]).{6,20})"  //number and small letter is compulsary required in password
        return Pattern.compile(passPattern).matcher(pass).matches()
    }


}
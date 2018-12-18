package com.neosoft.login.screen.loginscreen.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(

        @SerializedName("status")
        @Expose
        var status:Int,

        @SerializedName("data")
        @Expose
        var data:UserData,

        @SerializedName("message")
        @Expose
        var message:String,

        @SerializedName("user_msg")
        @Expose
        var userMsg:String

)


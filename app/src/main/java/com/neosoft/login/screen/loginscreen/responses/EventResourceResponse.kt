package com.neosoft.login.screen.loginscreen.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class EventResourceResponse(

    @SerializedName("id")
    @Expose
    var id:String,

    @SerializedName("status")
    @Expose
    var status:String,

    @SerializedName("summary")
    @Expose
    var summary:String,

    @SerializedName("description")
    @Expose
    var description:String,

    @SerializedName("creator")
    @Expose
    var creator:EventCreator,

    @SerializedName("start")
    @Expose
    var start:Start,

    @SerializedName("start")
    @Expose
    var end:End
)

data class End(

    @SerializedName("date")
    @Expose
    var startDate: Date

)

data class Start (

    @SerializedName("date")
    @Expose
    var endDate: Date

)

data class EventCreator (

    @SerializedName("id")
    @Expose
    var id:String,

    @SerializedName("email")
    @Expose
    var email:String

)


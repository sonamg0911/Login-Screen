package com.neosoft.login.screen.loginscreen.responses

import com.google.gson.annotations.SerializedName

data class CalendarListResponse(

    @SerializedName("kind")
    var kind:String,

    @SerializedName("nextPageToken")
    var nextPageToken:String,

    @SerializedName("nextSyncToken")
    var nextSyncToken:String,

    @SerializedName("items")
    var itemList:ArrayList<Resource>
)

data class Resource(

     @SerializedName("id")
     var id:String
)
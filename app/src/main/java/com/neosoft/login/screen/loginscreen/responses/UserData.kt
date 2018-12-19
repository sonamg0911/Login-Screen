package com.neosoft.login.screen.loginscreen.responses

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "userData")
data class UserData(

        @PrimaryKey
        @SerializedName("id")
        @Expose
        var id: Int,

        @SerializedName("role_id")
        @Expose
        var roleId: Int,

        @SerializedName("first_name")
        @Expose
        var firstName: String,

        @SerializedName("last_name")
        @Expose
        var lastName: String,

        @SerializedName("email")
        @Expose
        var email: String,

        @SerializedName("username")
        @Expose
        var username: String,

        @SerializedName("profile_pic")
        @Expose
        var profilePic: String?,

        @SerializedName("country_id")
        @Expose
        var countryId: String?,

        @SerializedName("gender")
        @Expose
        var gender: String,

        @SerializedName("phone_no")
        @Expose
        var phoneNo: String,

        @SerializedName("dob")
        @Expose
        var dob: String?,

        @SerializedName("is_active")
        @Expose
        var isActive: Boolean,

        @SerializedName("created")
        @Expose
        var created: String,

        @SerializedName("modified")
        @Expose
        var modified: String,

        @SerializedName("access_token")
        @Expose
        var accessToken: String

){
    @Ignore
    constructor():this(0,0,"","","","","","","","","",false,"","","")
}
package com.neosoft.login.screen.loginscreen.utils.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.neosoft.login.screen.loginscreen.responses.UserData

@Dao
interface UserDataDao{

    @Query("SELECT * from userData")
    fun getAllUserData():List<UserData>

    @Insert
    fun insertAll(userData: UserData)

    @Delete
    fun delete(userData: UserData)

}
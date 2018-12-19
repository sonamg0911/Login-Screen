package com.neosoft.login.screen.loginscreen.utils.database

import android.arch.persistence.room.*
import com.neosoft.login.screen.loginscreen.responses.UserData
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface UserDataDao{

    @Query("SELECT * from userData")
    fun getAllUserData():Flowable<List<UserData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(userData: UserData)

    @Query("SELECT * from userData where id=:userId")
    fun getUserDataFromId(userId:Int): Flowable<UserData>

    @Delete
    fun delete(userData: UserData)

}
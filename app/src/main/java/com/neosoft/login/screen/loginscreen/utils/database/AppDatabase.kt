package com.neosoft.login.screen.loginscreen.utils.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.neosoft.login.screen.loginscreen.responses.UserData

@Database(entities = [UserData::class],version = 1,exportSchema = false)
abstract class AppDatabase:RoomDatabase(){

    abstract fun userDataDao():UserDataDao

    companion object {

        private var INSTANCE:AppDatabase? = null

        fun getInstance(context:Context):AppDatabase?{

            if(INSTANCE==null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room
                            .databaseBuilder(context,AppDatabase::class.java,"data.db")
                            .build()
                }
            }

            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE=null
        }
    }
}
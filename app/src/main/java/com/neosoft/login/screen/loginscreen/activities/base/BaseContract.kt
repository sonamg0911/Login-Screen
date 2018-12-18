package com.neosoft.login.screen.loginscreen.activities.base

import android.widget.EditText
import com.neosoft.login.screen.loginscreen.utils.database.UserDataDao

interface BaseContract{

    interface View {
        fun showMessage(message:String)
        fun showErrorForEmptyField(field: EditText)
        fun showErrorForInvalidField(field: EditText)
        fun getUserDataDao():UserDataDao?
    }

}
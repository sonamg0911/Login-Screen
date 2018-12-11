package com.neosoft.login.screen.loginscreen.activities.base

import android.widget.EditText

interface BaseContract{

    interface View {
        fun showMessage(message:String)
        fun showErrorForEmptyField(field: EditText)
        fun showErrorForInvalidField(field: EditText)
    }

}
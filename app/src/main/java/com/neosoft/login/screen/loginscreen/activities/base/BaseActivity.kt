package com.neosoft.login.screen.loginscreen.activities.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import com.neosoft.login.screen.loginscreen.R

abstract class BaseActivity:AppCompatActivity(),BaseContract.View{

    private var basePresenter = BasePresenter<BaseContract.View>()

    override fun showMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun showErrorForEmptyField(field: EditText) {
        field.setError("This field is required",null)
        field.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_error_outline_indigo_24dp,0)
    }

    override fun showErrorForInvalidField(field: EditText) {
        field.setError("This field is Invalid",null)
        field.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_error_outline_indigo_24dp,0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentLayout())
        initViews()
        listeners()
    }

    override fun onDestroy() {
        basePresenter.detachView()
        super.onDestroy()
    }


    abstract fun listeners()

    abstract fun initViews()

    abstract fun getContentLayout():Int



}
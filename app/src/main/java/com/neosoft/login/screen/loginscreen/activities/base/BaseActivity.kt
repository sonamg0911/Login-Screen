package com.neosoft.login.screen.loginscreen.activities.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast

abstract class BaseActivity:AppCompatActivity(),BaseContract.View{

    private var basePresenter = BasePresenter<BaseContract.View>()

    override fun showMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun showErrorForEmptyField(field: EditText) {
        field.error = "This field is required"
    }

    override fun showErrorForInvalidField(field: EditText) {
        field.error = "This field is Invalid"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentLayout())
        intentData()
        initViews()
        listeners()
    }

    override fun onDestroy() {
        basePresenter.detachView()
        super.onDestroy()
    }

    abstract fun intentData()

    abstract fun listeners()

    abstract fun initViews()

    abstract fun getContentLayout():Int

}
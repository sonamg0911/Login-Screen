package com.neosoft.login.screen.loginscreen.activities.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import com.neosoft.login.screen.loginscreen.utils.database.AppDatabase
import com.neosoft.login.screen.loginscreen.utils.database.UserDataDao
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

abstract class BaseActivity<V : ViewDataBinding>:AppCompatActivity(),BaseContract.View{

    private var basePresenter = BasePresenter<BaseContract.View>()
    protected lateinit var binding:V
    private var db: AppDatabase? = null

    override fun showMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun showErrorForEmptyField(field: EditText) {
        field.error = "This field is required"
    }

    override fun showErrorForInvalidField(field: EditText) {
        field.error = "This field is Invalid"
    }

    override fun getUserDataDao(): UserDataDao? {
        return db?.userDataDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,getContentLayout())
        db = AppDatabase.getInstance(this)
        intentData()
        initViews()
        listeners()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun onDestroy() {
        basePresenter.disposeSubscription()
        basePresenter.detachView()
        AppDatabase.destroyInstance()
        super.onDestroy()
    }

    @Subscribe
    fun showErrorMessage(t:Throwable){
        showMessage(t.message!!)
    }

    abstract fun intentData()

    abstract fun listeners()

    abstract fun initViews()

    abstract fun getContentLayout():Int

}
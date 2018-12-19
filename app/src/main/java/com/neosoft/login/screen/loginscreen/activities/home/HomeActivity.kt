package com.neosoft.login.screen.loginscreen.activities.home

import android.os.Bundle
import com.neosoft.login.screen.loginscreen.R
import com.neosoft.login.screen.loginscreen.activities.base.BaseActivity
import com.neosoft.login.screen.loginscreen.databinding.ActivityHomeBinding
import com.neosoft.login.screen.loginscreen.responses.UserData
import com.neosoft.login.screen.loginscreen.utils.ID
import io.reactivex.android.schedulers.AndroidSchedulers

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private var id:Int = 0
    override fun intentData() {
        id = intent.getIntExtra(ID,0)
    }

    override fun listeners() {

    }

    override fun initViews() {

    }

    override fun getContentLayout(): Int { return R.layout.activity_home }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.model = HomeBindingModel()
        getUserDataDao()?.getUserDataFromId(id)
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { t -> bindDataWithView(t)}
    }

    private fun bindDataWithView(data: UserData) {
        binding.model?.firstName = data.firstName
        binding.model?.lastName = data.lastName
        binding.model?.modified = data.modified
        binding.model?.phoneNo = data.phoneNo
        binding.model?.accessToken = data.accessToken
    }

}

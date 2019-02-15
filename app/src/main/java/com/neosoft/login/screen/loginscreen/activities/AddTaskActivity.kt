package com.neosoft.login.screen.loginscreen.activities

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.neosoft.login.screen.loginscreen.R
import com.neosoft.login.screen.loginscreen.activities.base.BaseActivity
import com.neosoft.login.screen.loginscreen.databinding.ActivityAddTaskBinding

class AddTaskActivity: BaseActivity<ActivityAddTaskBinding>(){

    private lateinit var toolbarTitle:TextView
    private lateinit var toolBarButton:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        modifyToolbar()
    }

    private fun modifyToolbar() {
        toolbarTitle.text = "Add Task"
        toolBarButton.visibility = View.GONE
    }

    override fun intentData() {


    }

    override fun listeners() {

    }

    override fun initViews() {
        toolbarTitle = binding.layoutToolbar!!.findViewById(R.id.txt_title)
        toolBarButton = binding.layoutToolbar!!.findViewById(R.id.img_tool_2)

    }

    override fun getContentLayout(): Int {
        return R.layout.activity_add_task
    }

}
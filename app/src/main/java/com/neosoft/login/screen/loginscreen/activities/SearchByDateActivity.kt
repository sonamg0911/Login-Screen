package com.neosoft.login.screen.loginscreen.activities

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.neosoft.login.screen.loginscreen.R
import com.neosoft.login.screen.loginscreen.activities.base.BaseActivity
import com.neosoft.login.screen.loginscreen.databinding.ActivitySearchByDateBinding

class SearchByDateActivity:BaseActivity<ActivitySearchByDateBinding>(){

    private lateinit var toolbarTitle: TextView
    private lateinit var toolbarIcon:ImageView
    private lateinit var tvDateTitle:TextView
    private lateinit var tvDateMonthYear:TextView
    private lateinit var tvDate:TextView
    private lateinit var tvDateDay:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        modifyToolbar()
        setData()
    }

    private fun setData() {
        tvDateTitle.text = "End Date"
        tvDate.text = "19"
        tvDateDay.text = "Monday"
    }

    private fun modifyToolbar() {
        toolbarTitle.text = "Search By Date"
        toolbarIcon.visibility =  View.GONE
    }

    override fun intentData() {

    }

    override fun listeners() {

    }

    override fun initViews() {
        toolbarTitle = binding.layoutToolbar!!.findViewById(R.id.txt_title)
        toolbarIcon = binding.layoutToolbar!!.findViewById(R.id.img_tool_2)
        tvDate = binding.layoutCalendarEndDate!!.findViewById(R.id.tv_date)
        tvDateTitle = binding.layoutCalendarEndDate!!.findViewById(R.id.tv_date_title)
        tvDateMonthYear = binding.layoutCalendarEndDate!!.findViewById(R.id.tv_date_month_year)
        tvDateDay = binding.layoutCalendarEndDate!!.findViewById(R.id.tv_date_day)
    }

    override fun getContentLayout(): Int {
        return R.layout.activity_search_by_date
    }


}
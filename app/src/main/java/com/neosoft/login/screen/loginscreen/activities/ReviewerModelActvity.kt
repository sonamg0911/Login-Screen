package com.neosoft.login.screen.loginscreen.activities

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.widget.AppCompatSpinner
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import com.neosoft.login.screen.loginscreen.R
import com.neosoft.login.screen.loginscreen.activities.base.BaseActivity
import com.neosoft.login.screen.loginscreen.adapters.ReviewerModelFilterAdapter
import com.neosoft.login.screen.loginscreen.databinding.ActivityReviewerModelBinding


class ReviewerModelActivity:BaseActivity<ActivityReviewerModelBinding>(),TabLayout.OnTabSelectedListener{

    private lateinit var toolbarTitle: TextView
    private lateinit var tabLayout: TabLayout
    private lateinit var layoutFilter:View
    private lateinit var layoutFilterByCustomer:View
    private lateinit var layoutFilterByProduct:View
    private lateinit var recyclerViewCustomer:RecyclerView
    private lateinit var recyclerViewProduct:RecyclerView
    private lateinit var layoutManager:RecyclerView.LayoutManager
    private lateinit var reviewerModelAdapter:ReviewerModelFilterAdapter
    private lateinit var spinnerCustomer:AppCompatSpinner
    private lateinit var spinnerProduct:AppCompatSpinner
    private lateinit var adapter:ArrayAdapter<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        modifyToolbar()
        setTabsInTabLayout()
        setSpinners()
        setFilterAdapterForCustomer()
        setFilterAdapterForProduct()
    }

    private fun setSpinners() {

    }

    private fun setTabsInTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("BY CUSTOMER"))
        tabLayout.addTab(tabLayout.newTab().setText("BY PRODUCT"))
        tabLayout.tabGravity= TabLayout.GRAVITY_FILL
        tabLayout.addOnTabSelectedListener(this)
    }

    private fun modifyToolbar() {
        toolbarTitle.text = "Reviewer Model"
    }

    override fun intentData() {

    }

    override fun listeners() {


    }

    override fun initViews() {
        toolbarTitle = binding.layoutToolbar!!.findViewById(R.id.txt_title)
        layoutFilter = findViewById(R.id.layout_reviewer_model_filter)
        layoutFilterByCustomer=layoutFilter.findViewById(R.id.layout_filter_by_customer)
        layoutFilterByProduct=layoutFilter.findViewById(R.id.layout_filter_by_product)
        tabLayout = layoutFilter.findViewById(R.id.tl_product_or_customer)
        recyclerViewCustomer = layoutFilterByCustomer.findViewById(R.id.rv_customer)
        recyclerViewProduct = layoutFilterByProduct.findViewById(R.id.rv_product)
        spinnerCustomer=layoutFilterByCustomer.findViewById(R.id.sp_filter_customer)
        spinnerProduct=layoutFilterByProduct.findViewById(R.id.sp_filter_product)
        recyclerViewCustomer = layoutFilterByCustomer.findViewById(R.id.rv_customer)
        recyclerViewProduct = layoutFilterByProduct.findViewById(R.id.rv_product)
        spinnerCustomer=layoutFilterByCustomer.findViewById(R.id.sp_filter_customer)
        spinnerProduct=layoutFilterByProduct.findViewById(R.id.sp_filter_product)
        adapter = ArrayAdapter.createFromResource(this, R.array.array_filter_by_customer, R.layout.custom_spinner)
        spinnerCustomer.adapter = adapter
        adapter = ArrayAdapter.createFromResource(this, R.array.array_filter_by_product, R.layout.custom_spinner)
        spinnerProduct.adapter = adapter
    }

    override fun getContentLayout(): Int {
        return R.layout.activity_reviewer_model
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        if(tab?.position == 0) {
            layoutFilterByCustomer.visibility=View.VISIBLE
            layoutFilterByProduct.visibility=View.INVISIBLE

        }
        else {
            layoutFilterByCustomer.visibility=View.INVISIBLE
            layoutFilterByProduct.visibility=View.VISIBLE

        }
    }

    private fun setFilterAdapterForProduct() {
        recyclerViewProduct.isNestedScrollingEnabled = false
        recyclerViewProduct.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerViewProduct.layoutManager = layoutManager
        reviewerModelAdapter = ReviewerModelFilterAdapter(this,"Product")
        recyclerViewProduct.adapter = reviewerModelAdapter
    }

    private fun setFilterAdapterForCustomer() {
        recyclerViewCustomer.isNestedScrollingEnabled = false
        recyclerViewCustomer.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerViewCustomer.layoutManager = layoutManager
        reviewerModelAdapter = ReviewerModelFilterAdapter(this,"Customer")
        recyclerViewCustomer.adapter = reviewerModelAdapter
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }

}
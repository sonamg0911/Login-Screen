package com.neosoft.login.screen.loginscreen.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.neosoft.login.screen.loginscreen.R
import com.neosoft.login.screen.loginscreen.activities.base.BaseActivity
import com.neosoft.login.screen.loginscreen.adapters.CustomerIssuesListAdapter
import com.neosoft.login.screen.loginscreen.adapters.CustomerOpportunitiesListAdapter
import com.neosoft.login.screen.loginscreen.databinding.ActivityCustomerSearchBinding

class CustomerSearchActivity: BaseActivity<ActivityCustomerSearchBinding>(){

    private lateinit var toolbarTitle: TextView
    private lateinit var issuesRecyclerView: RecyclerView
    private lateinit var opportunitiesRecyclerView: RecyclerView
    lateinit var opportunitiesAdapter: CustomerOpportunitiesListAdapter
    lateinit var issuesAdapter: CustomerIssuesListAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        modifyToolbar()
    }

    private fun modifyToolbar() {
        toolbarTitle.text = "Customer Search"
    }

    override fun intentData() {


    }

    override fun listeners() {
        binding.tvIssues1.setOnClickListener {
            binding.llToggle1.visibility = View.INVISIBLE
            binding.llToggle2.visibility = View.VISIBLE
            binding.layoutIssues?.visibility = View.VISIBLE
            binding.layoutOpportunities?.visibility = View.INVISIBLE
        }
        binding.tvIssues2.setOnClickListener {

        }

        binding.tvOpportunities1.setOnClickListener {
        }

        binding.tvOpportunities2.setOnClickListener {
            binding.llToggle1.visibility = View.VISIBLE
            binding.llToggle2.visibility = View.INVISIBLE
            binding.layoutIssues?.visibility = View.INVISIBLE
            binding.layoutOpportunities?.visibility = View.VISIBLE
        }

    }

    override fun initViews() {
        toolbarTitle = binding.layoutToolbar!!.findViewById(R.id.txt_title)
        setIssuesAdapter()
        setOpportunitiesAdapter()
    }

    private fun setIssuesAdapter(){
        issuesRecyclerView = binding.layoutIssues!!.findViewById(R.id.rv_issues)
        issuesRecyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        issuesRecyclerView.layoutManager = layoutManager
        issuesAdapter = CustomerIssuesListAdapter(this)
        issuesRecyclerView.adapter = issuesAdapter
    }

    private fun setOpportunitiesAdapter(){
        opportunitiesRecyclerView = binding.layoutOpportunities!!.findViewById(R.id.rv_opportunities)
        opportunitiesRecyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        opportunitiesRecyclerView.layoutManager = layoutManager
        opportunitiesAdapter = CustomerOpportunitiesListAdapter(this)
        opportunitiesRecyclerView.adapter = opportunitiesAdapter
    }

    override fun getContentLayout(): Int {
        return R.layout.activity_customer_search
    }

}
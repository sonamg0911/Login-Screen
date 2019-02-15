package com.neosoft.login.screen.loginscreen.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neosoft.login.screen.loginscreen.R

class CustomerOpportunitiesListAdapter(val context: Context?): RecyclerView.Adapter<CustomerOpportunitiesListAdapter.CustomerOpportunitiesListHolder>(){

    private lateinit var v: View

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): CustomerOpportunitiesListAdapter.CustomerOpportunitiesListHolder {
        v = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_layout_opportunities, viewGroup, false)
        return CustomerOpportunitiesListHolder(v)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: CustomerOpportunitiesListAdapter.CustomerOpportunitiesListHolder, p1: Int) {

    }

    inner class CustomerOpportunitiesListHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
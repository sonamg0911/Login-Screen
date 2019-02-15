package com.neosoft.login.screen.loginscreen.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.neosoft.login.screen.loginscreen.R

class CustomerIssuesListAdapter(val context: Context?):RecyclerView.Adapter<CustomerIssuesListAdapter.CustomerIssuesViewHolder>(){

    private lateinit var v: View

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): CustomerIssuesListAdapter.CustomerIssuesViewHolder {
        v=LayoutInflater.from(viewGroup.context).inflate(R.layout.row_layout_issues, viewGroup, false)
        return CustomerIssuesViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(viewHolder: CustomerIssuesListAdapter.CustomerIssuesViewHolder, position: Int) {

        if(position==4 || position==6) viewHolder.itemView.findViewById<TextView>(R.id.txt_issue_type_name).text = "Payment refund request"
        if(position==9) viewHolder.itemView.findViewById<View>(R.id.line_gray).visibility = View.GONE

    }

    inner class CustomerIssuesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)




}
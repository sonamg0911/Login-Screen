package com.neosoft.login.screen.loginscreen.adapters

import android.content.Context
import android.opengl.Visibility
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.neosoft.login.screen.loginscreen.R

class ReviewerModelFilterAdapter(val context: Context?,val filterType:String): RecyclerView.Adapter<ReviewerModelFilterAdapter.ReviewerModelFilterHolder>(){

    private lateinit var v: View

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ReviewerModelFilterAdapter.ReviewerModelFilterHolder {
        v = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_layout_filter, viewGroup, false)
        return ReviewerModelFilterHolder(v)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ReviewerModelFilterAdapter.ReviewerModelFilterHolder, position: Int) {
        if(filterType == "Product"){
            holder.productType.visibility = View.INVISIBLE
            holder.productName.visibility = View.INVISIBLE
        }else{
            holder.productType.visibility = View.VISIBLE
            holder.productName.visibility = View.VISIBLE
        }

    }

    inner class ReviewerModelFilterHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var productType:TextView = itemView.findViewById(R.id.tv_product_type)
        var productName:TextView = itemView.findViewById(R.id.tv_product_type_name)
    }
}
package com.neosoft.login.screen.loginscreen.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neosoft.login.screen.loginscreen.R

class BarcodeListAdapter(val context: Context?): RecyclerView.Adapter<BarcodeListAdapter.BarcodeListHolder>(){

    private lateinit var v:View

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): BarcodeListAdapter.BarcodeListHolder {
        v = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_layout_barcode, viewGroup, false)
        return BarcodeListHolder(v)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: BarcodeListAdapter.BarcodeListHolder, p1: Int) {

    }

    inner class BarcodeListHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
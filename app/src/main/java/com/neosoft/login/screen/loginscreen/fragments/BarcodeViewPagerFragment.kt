package com.neosoft.login.screen.loginscreen.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neosoft.login.screen.loginscreen.R
import com.neosoft.login.screen.loginscreen.adapters.BarcodeListAdapter

class BarcodeViewPagerFragment:Fragment(){

    lateinit var barcodeItemRecyclerView: RecyclerView
    lateinit var adapter:BarcodeListAdapter
    lateinit var layoutManager:RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_barcode_viewpager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
    }

    private fun initView(view: View?) {
        if(view!=null)
        barcodeItemRecyclerView = view.findViewById(R.id.rv_barcode_item_list)
        barcodeItemRecyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        barcodeItemRecyclerView.layoutManager = layoutManager
        adapter = BarcodeListAdapter(context)
        barcodeItemRecyclerView.adapter = adapter

    }


}
package com.neosoft.login.screen.loginscreen.activities

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.neosoft.login.screen.loginscreen.R
import com.neosoft.login.screen.loginscreen.activities.base.BaseActivity
import com.neosoft.login.screen.loginscreen.adapters.BarcodeTypePagerAdapter
import com.neosoft.login.screen.loginscreen.databinding.ActivityBarcodeBinding

class BarcodeActivity:BaseActivity<ActivityBarcodeBinding>(){
    private lateinit var barcodeTab:TabLayout
    private lateinit var barcodeViewPager:ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpTabAndViewPager()
    }

    override fun intentData() {


    }

    override fun listeners() {

    }

    override fun initViews() {
        barcodeTab=findViewById(R.id.tl_barcode_names)
        barcodeViewPager=findViewById(R.id.vp_barcode)

    }

    override fun getContentLayout(): Int {
        return R.layout.activity_barcode
    }

    private fun setUpTabAndViewPager() {
        barcodeTab.tabGravity = TabLayout.GRAVITY_FILL

        //Creating our pager adapter
        val adapter = BarcodeTypePagerAdapter(supportFragmentManager)
        barcodeViewPager.adapter = adapter

        barcodeTab.setupWithViewPager(barcodeViewPager)
        barcodeTab.getTabAt(0)!!.text = "PROCESSED"
        barcodeTab.getTabAt(1)!!.text = "ON HOLD"
        barcodeTab.getTabAt(2)!!.text = "REJECTED"
        barcodeTab.getTabAt(3)!!.text = "IN PROCESS"
    }

}
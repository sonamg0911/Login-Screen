package com.neosoft.login.screen.loginscreen.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.neosoft.login.screen.loginscreen.fragments.BarcodeViewPagerFragment

class BarcodeTypePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var mFragment: List<Fragment>

    init {
        mFragment = getList()
    }

    override fun getItem(position: Int): Fragment {
        return mFragment[position]
    }

    override fun getCount(): Int {
        return mFragment.size
    }

    private fun getList(): List<Fragment> {
        val list = ArrayList<Fragment>()
        list.add(BarcodeViewPagerFragment())
        list.add(BarcodeViewPagerFragment())
        list.add(BarcodeViewPagerFragment())
        list.add(BarcodeViewPagerFragment())
        return list
    }
}
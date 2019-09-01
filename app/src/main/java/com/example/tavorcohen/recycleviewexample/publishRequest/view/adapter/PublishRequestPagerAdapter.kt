package com.example.tavorcohen.recycleviewexample.publishRequest.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.tavorcohen.recycleviewexample.publishRequest.view.fragment.PublishRequestStep1Fragment
import com.example.tavorcohen.recycleviewexample.publishRequest.view.fragment.PublishRequestStep2Fragment
import com.example.tavorcohen.recycleviewexample.publishRequest.view.fragment.PublishRequestStep3Fragment
import com.example.tavorcohen.recycleviewexample.publishRequest.view.fragment.PublishRequestStep4Fragment

class PublishRequestPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager)  {

    var idCategory : String? =""
    // Returns total number of pages
    override fun getCount(): Int {
        return NUM_ITEMS
    }

    // Returns the fragment to display for that page
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0
            -> return PublishRequestStep1Fragment.newInstance()
            1
            -> return PublishRequestStep2Fragment.newInstance()
            2
            -> return PublishRequestStep3Fragment.newInstance()
            3
            -> return PublishRequestStep4Fragment.newInstance()
            else -> return null
        }
    }

    // Returns the page title for the top indicator
    override fun getPageTitle(position: Int): CharSequence? {
        return "Page $position"
    }

    companion object {
        private const val NUM_ITEMS = 4
    }


}
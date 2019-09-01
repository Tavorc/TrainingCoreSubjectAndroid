package com.example.tavorcohen.recycleviewexample.view.header

import android.content.Context
import android.util.AttributeSet

/**
 * Header with back button and title
 * # If there have needed header with only title you need to set visibility of the back button
 */
open class RegularHeader @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseHeader(context, attrs, defStyleAttr) {

    lateinit var mListener : OnBackClick

    override fun activeBackButton() {
       mListener.onBack(this)
    }
}
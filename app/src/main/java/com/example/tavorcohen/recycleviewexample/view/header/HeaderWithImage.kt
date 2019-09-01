package com.example.tavorcohen.recycleviewexample.view.header

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.example.tavorcohen.recycleviewexample.R
import kotlinx.android.synthetic.main.header_with_image.view.*

/**
 * Header with close button
 */
class HeaderWithImage @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseHeader(context, attrs, defStyleAttr), View.OnClickListener {

    lateinit var mListener : IHeaderWithImage
    init {
        LayoutInflater.from(context)
                .inflate(R.layout.header_with_image, this, true)
        setListener()
    }

    private fun setListener(){
        imageClose.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when(v){
            imageClose ->{
                mListener.onClose(this)
            }
        }
    }

    override fun activeBackButton() {
        return
    }

    /**
     * interface that represent listener to close button
     */
    interface IHeaderWithImage{
        fun onClose(baseHeader: BaseHeader)
    }
}
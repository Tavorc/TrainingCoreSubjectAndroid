package com.example.tavorcohen.recycleviewexample.view.header

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.example.tavorcohen.recycleviewexample.R
import kotlinx.android.synthetic.main.header_with_two_image.view.*


/**
 * Header with share button and delete button
 */
class HeaderWithTwoImage @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseHeader(context, attrs, defStyleAttr) {

    lateinit var mListener : OnBackClick
    lateinit var mDeleteAndShareListener : IHeaderWithTwoImage

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.header_with_two_image, this, true)
        setListeners()
    }

    /**
     * set the listeners of the relevant buttons
     */
    private fun setListeners(){
        deleteImage.setOnClickListener(this)
        shareImage.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when(v){
            deleteImage ->{
                mDeleteAndShareListener.onDelete(this)
            }

            shareImage -> {
                mDeleteAndShareListener.onShare(this)
            }
        }
    }

    override fun activeBackButton() {
        mListener.onBack(this)
    }

    interface IHeaderWithTwoImage {
        fun onShare(baseHeader: BaseHeader)
        fun onDelete(baseHeader: BaseHeader)
    }
}
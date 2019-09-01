package com.example.tavorcohen.recycleviewexample.view.header

import android.content.Context
import android.graphics.drawable.Drawable

import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.example.tavorcohen.recycleviewexample.R
import com.wefixapp.wefixisr.v2.view.utils.ImageUtils

import kotlinx.android.synthetic.main.base_header_layout.view.*

/**
 * Base header with title and back button
 */
abstract class BaseHeader @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) :  ConstraintLayout(context, attrs, defStyleAttr), View.OnClickListener {

    /**
     * initialize the layout and change the direction of the arrow according to the language of the device
     */
    init {
        LayoutInflater.from(context)
                .inflate(R.layout.base_header_layout, this, true)

        ImageUtils.configureForLeftToRight(resources,backButton,-1f)
        setListener()
    }

    private fun setListener(){
        backButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            backButton ->{
                activeBackButton()
            }
        }
    }

    /**
     * set title of the header
     */
    fun setTitle(text: String ){
        titleHeader.text = text
    }

    fun setTitleColor(color : Int){
        titleHeader.setTextColor(color)
    }
    /**
     * set the image of the back button (in the right side when it's hebrew)
     */
    fun setBackImage( image : Drawable){
        backButton.setImageDrawable(image)
    }
    fun setColorBackButton(color : Int){
        backButton.setColorFilter(color)
    }

    /**
     * set background of the header
     */
    fun setBackgroundHeader(color : Int) {
        headerLayout.setBackgroundColor(color)
    }

    /**
     * set visibility the back button image
     */
    fun setVisibilityBackImage(visibility : Int){
        backButton.visibility = visibility
    }

    /**
     * An Abstract method that execute when the user click on back button
     */
    abstract fun activeBackButton()

}
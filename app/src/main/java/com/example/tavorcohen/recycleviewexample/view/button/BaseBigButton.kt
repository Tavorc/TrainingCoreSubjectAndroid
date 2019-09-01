package com.example.tavorcohen.recycleviewexample.view.button

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.example.tavorcohen.recycleviewexample.R
import com.wefixapp.wefixisr.v2.view.utils.ImageUtils
import kotlinx.android.synthetic.main.base_big_button.view.*


open class BaseBigButton @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) :  ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var mListener : BaseBigButton

    init {
        LayoutInflater.from(context)
                .inflate(R.layout.base_big_button, this, true)
        ImageUtils.configureForLeftToRight(resources,nextImage,1f)
        buttonLayout.setOnClickListener {
            mListener.onClickBigButton(it)
        }
    }

    fun setClickableBigButton(isClickable : Boolean){
        buttonLayout.isClickable = isClickable
    }
    /**
     * change the attributes and create the regular big button
     */
    fun buildRegularButton(){
        nextImage.visibility = View.GONE
        val params = titleButton.getLayoutParams() as LayoutParams

        val constraintSet = ConstraintSet()
        constraintSet.clone(buttonLayout)
        constraintSet.connect(R.id.titleButton, ConstraintSet.BOTTOM, R.id.buttonLayout, ConstraintSet.BOTTOM, 0)
        constraintSet.connect(R.id.titleButton, ConstraintSet.TOP, R.id.buttonLayout, ConstraintSet.TOP, 0)
        constraintSet.connect(R.id.titleButton, ConstraintSet.END, R.id.buttonLayout, ConstraintSet.END, 0)
        constraintSet.connect(R.id.titleButton, ConstraintSet.START, R.id.buttonLayout, ConstraintSet.START, 0)
        constraintSet.applyTo(buttonLayout)
        titleButton.layoutParams = params
    }

    fun locateTitlePublishRequest(){

    }
    fun setButtonBackgroundColor(color : Int){
        buttonLayout.setBackgroundResource(color)
    }

    fun setButtonText(title : String){
        titleButton.text = title
    }

    interface BaseBigButton {
        fun onClickBigButton(baseBigButton : View)
    }
}
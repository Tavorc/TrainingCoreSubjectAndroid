package com.example.tavorcohen.recycleviewexample.view.header

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.example.tavorcohen.recycleviewexample.R
import kotlinx.android.synthetic.main.header_with_button_layout.view.*


/**
 * Header with save button
 */
class HeaderWithButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseHeader(context, attrs, defStyleAttr) {

    lateinit var mListener : OnBackClick
    lateinit var mSaveListener : IHeaderWithButton
    private lateinit var mGradientDrawable : GradientDrawable

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.header_with_button_layout, this, true)
        mGradientDrawable = GradientDrawable()
        setInitialBackgroundButton()
        saveButton.setOnClickListener(this)
    }

    /**
     * set background for the save button
     */
    private fun setInitialBackgroundButton(){
        val color1 = resources.getColor(R.color.dark_blue)
        mGradientDrawable.cornerRadius = 5f
        mGradientDrawable.setStroke(2,color1)
        mGradientDrawable.shape = GradientDrawable.RECTANGLE
        mGradientDrawable.setColor(color1)
        saveButton.background = mGradientDrawable
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when(v){
            saveButton -> {
                mSaveListener.onSave(this)
            }
        }
    }
    override fun activeBackButton() {
        mListener.onBack(this)
    }

    /**
     * change the background color of the button
     */
    fun setBackgroundButton(color: Int){
        mGradientDrawable.setColor(color)
    }

    /**
     * set the text of the button in the left side(when the language is hebrew)
     */
    fun setButtonText(text : String){
        textButton.text = text
    }

    /**
     * listener for save button
     */
    interface IHeaderWithButton{
        fun onSave(baseHeader: BaseHeader)
    }
}
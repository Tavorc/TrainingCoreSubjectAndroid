package com.example.tavorcohen.recycleviewexample.view.button

import android.content.Context
import android.util.AttributeSet

class RegularBigButton @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseBigButton(context, attrs, defStyleAttr) {


    init {
        buildRegularButton()
    }
}
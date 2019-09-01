package com.example.tavorcohen.recycleviewexample.customStepBar

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.example.tavorcohen.recycleviewexample.R
import com.example.tavorcohen.recycleviewexample.utils.LayoutUtils
import kotlinx.android.synthetic.main.steps_bar_layout.view.*


class StepsBarView : LinearLayout {

    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr)


    private val SIZE : Int = 3
    var viewList : ArrayList<View> = ArrayList()

    private var layoutStepBar : LinearLayout


init {
    LayoutInflater.from(context)
        .inflate(R.layout.steps_bar_layout, this, true)

    layoutStepBar = findViewById(R.id.layoutStepBar)

    var view : View = View(context)


    for(i in 0 until SIZE ){
            if(i == 0){
                view = drawCircle(layoutStepBar,0)
                view = drawPath(view,view.right)

            }
        else{
                view = drawCircle(view,view.right *i  - ( i* ((width-90)/2)))

            }


    }

}

    private fun drawCircle(view: View,xMargin :Int) : View {

        val circle = Circle(context)

        circle.layoutParams = ViewGroup.LayoutParams(LayoutUtils.convertDpToPixel(context, 30), LayoutUtils.convertDpToPixel(context, 30))

        var params1 = LayoutParams(
            LayoutUtils.convertDpToPixel(context, 30),
            LayoutUtils.convertDpToPixel(context, 30)
        )
        var margin= LayoutUtils.convertDpToPixel(context, xMargin)

        view.x = margin.toFloat()
        view.layoutParams = params1

        addView(circle)

        viewList.add(circle)
        return circle
    }

    private fun drawPath(view: View,xMargin :Int): View {

        val path = PathView(context)
         path.layoutParams = ViewGroup.LayoutParams(LayoutUtils.convertDpToPixel(context, 30), LayoutUtils.convertDpToPixel(context, 3))

        path.setBackgroundColor(resources.getColor(R.color.gray_bar))


        var margin= LayoutUtils.convertDpToPixel(context, xMargin)
       // view.x = margin.toFloat()

        addView(path)

        viewList.add(path)
        return path
    }





}
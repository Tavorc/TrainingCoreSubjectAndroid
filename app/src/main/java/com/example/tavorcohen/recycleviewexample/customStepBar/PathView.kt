package com.example.tavorcohen.recycleviewexample.customStepBar

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View


class PathView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var path: Path = Path()
    private var paint: Paint = Paint()
    private var length: Float = 0.toFloat()



    init{
        paint.color = Color.BLUE
        paint.strokeWidth = 10F
        paint.style = Paint.Style.STROKE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            id = generateViewId()
        }


    }

    //is called by animtor object
    fun setPhase(phase: Float) {
        Log.d("pathview", "setPhase called with:$phase")
        paint.pathEffect = createPathEffect(length, phase, 0.0f)
        invalidate()//will calll onDraw
    }

    private fun createPathEffect(pathLength: Float, phase: Float, offset: Float): PathEffect {
        return DashPathEffect(
            floatArrayOf(pathLength, pathLength),
            Math.max(phase * pathLength, offset)
        )
    }



    override fun onDraw(c: Canvas) {
        super.onDraw(c)


        c.concat(matrix)
        c.drawPath(path, paint)
    }
}
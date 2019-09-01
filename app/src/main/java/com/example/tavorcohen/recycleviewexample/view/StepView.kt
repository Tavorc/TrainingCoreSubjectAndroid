package com.example.tavorcohen.recycleviewexample.view

import android.graphics.Typeface
import android.view.ViewGroup

import android.widget.TextView

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.FrameLayout
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.tavorcohen.recycleviewexample.R


class StepView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), StepsViewIndicator.OnDrawListener {

    private var mStepsViewIndicator: StepsViewIndicator? = null
    private var mLabelsLayout: FrameLayout? = null
    private var mLabels: Array<String>? = null
    private var mProgressColorIndicator = Color.YELLOW
    private var mLabelColorIndicator = Color.BLACK
    private var mBarColorIndicator = Color.BLACK
    private var mCompletedPosition = 0

    init {
        init()
    }

    private fun init() {
        val rootView = LayoutInflater.from(context).inflate(R.layout.widget_steps_view, this)
        mStepsViewIndicator = rootView.findViewById(R.id.steps_indicator_view)
        mStepsViewIndicator!!.setDrawListener(this)
        mLabelsLayout = rootView.findViewById(R.id.labels_container)
    }

    fun getLabels(): Array<String>? {
        return mLabels
    }

    fun setLabels(labels: Array<String>): StepView {
        mLabels = labels
        mStepsViewIndicator!!.setStepSize(labels.size)
        return this
    }

    fun getProgressColorIndicator(): Int {
        return mProgressColorIndicator
    }

    fun setProgressColorIndicator(progressColorIndicator: Int): StepView {
        mProgressColorIndicator = progressColorIndicator
        mStepsViewIndicator!!.setProgressColor(mProgressColorIndicator)
        return this
    }

    fun getLabelColorIndicator(): Int {
        return mLabelColorIndicator
    }

    fun setLabelColorIndicator(labelColorIndicator: Int): StepView {
        mLabelColorIndicator = labelColorIndicator
        return this
    }

    fun getBarColorIndicator(): Int {
        return mBarColorIndicator
    }

    fun setBarColorIndicator(barColorIndicator: Int): StepView {
        mBarColorIndicator = barColorIndicator
        mStepsViewIndicator!!.setBarColor(mBarColorIndicator)
        return this
    }

    fun getCompletedPosition(): Int {
        return mCompletedPosition
    }

    fun setCompletedPosition(completedPosition: Int): StepView {
        mCompletedPosition = completedPosition
        mStepsViewIndicator!!.setCompletedPosition(mCompletedPosition)
        return this
    }

    fun drawView() {
        if (mLabels == null) {
            throw IllegalArgumentException("labels must not be null.")
        }

        if (mCompletedPosition < 0 || mCompletedPosition > mLabels!!.size - 1) {
            throw IndexOutOfBoundsException(String.format("Index : %s, Size : %s", mCompletedPosition, mLabels!!.size))
        }

        mStepsViewIndicator!!.invalidate()
    }

    override fun onReady() {
        drawLabels()
    }

    private fun drawLabels() {
        val indicatorPosition = mStepsViewIndicator!!.thumbContainerXPosition

        if (mLabels != null) {
            for (i in mLabels!!.indices) {
                val textView = TextView(context)
                textView.text = mLabels!![i]
                textView.setTextColor(mLabelColorIndicator)
                textView.x = indicatorPosition[i]
                textView.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                if (i <= mCompletedPosition) {
                    textView.setTypeface(null, Typeface.BOLD)
                }

                mLabelsLayout!!.addView(textView)
            }
        }
    }
}
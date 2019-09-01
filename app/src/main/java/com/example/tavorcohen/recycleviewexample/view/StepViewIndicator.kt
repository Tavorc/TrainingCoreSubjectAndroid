package com.example.tavorcohen.recycleviewexample.view



import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.tavorcohen.recycleviewexample.R


class StepsViewIndicator @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    View(context, attrs, defStyle) {

    private val paint = Paint()
    private val selectedPaint = Paint()
    private var mNumOfStep = 2
    private var mLineHeight: Float = 0.toFloat()
    private var mThumbRadius: Float = 0.toFloat()
    private var mCircleRadius: Float = 0.toFloat()
    private var mPadding: Float = 0.toFloat()
    private var mProgressColor = Color.YELLOW
    private var mBarColor = Color.BLACK

    private var mCenterY: Float = 0.toFloat()
    private var mLeftX: Float = 0.toFloat()
    private var mLeftY: Float = 0.toFloat()
    private var mRightX: Float = 0.toFloat()
    private var mRightY: Float = 0.toFloat()
    private var mDelta: Float = 0.toFloat()
    var mThumbContainerXPosition : ArrayList<Float> = ArrayList()
    private var mCompletedPosition: Int = 0
    private var mDrawListener: OnDrawListener? = null

    val thumbContainerXPosition: List<Float>
        get() = mThumbContainerXPosition

    init {
        val a = context.obtainStyledAttributes(
            attrs,
            R.styleable.StepsViewIndicator
        )
        mNumOfStep = a.getInt(R.styleable.StepsViewIndicator_numOfSteps, 0)
        a.recycle()

        init()
    }

    private fun init() {
        mLineHeight = 0.2f * THUMB_SIZE
        mThumbRadius = 0.4f * THUMB_SIZE
        mCircleRadius = 0.7f * mThumbRadius
        mPadding = 0.5f * THUMB_SIZE
    }

    fun setStepSize(size: Int) {
        mNumOfStep = size
        invalidate()
    }

    fun setDrawListener(drawListener: OnDrawListener) {
        mDrawListener = drawListener
    }

  override  fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        mCenterY = 0.5f * getHeight()
        mLeftX = mPadding
        mLeftY = mCenterY - mLineHeight / 2
        mRightX = getWidth() - mPadding
        mRightY = 0.5f * (getHeight() + mLineHeight)
        mDelta = (mRightX - mLeftX) / (mNumOfStep - 1)

        mThumbContainerXPosition.add(mLeftX)
        for (i in 1 until mNumOfStep - 1) {
            mThumbContainerXPosition.add(mLeftX + i * mDelta)
        }
        mThumbContainerXPosition.add(mRightX)
        mDrawListener!!.onReady()
    }

    @Synchronized
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var width = 200
        if (MeasureSpec.UNSPECIFIED != MeasureSpec.getMode(widthMeasureSpec)) {
            width = MeasureSpec.getSize(widthMeasureSpec)
        }
        var height = THUMB_SIZE + 20
        if (MeasureSpec.UNSPECIFIED != MeasureSpec.getMode(heightMeasureSpec)) {
            height = Math.min(height, MeasureSpec.getSize(heightMeasureSpec))
        }
        setMeasuredDimension(width, height)
    }

    fun setCompletedPosition(position: Int) {
        mCompletedPosition = position
    }

    fun reset() {
        setCompletedPosition(0)
    }

    fun setProgressColor(progressColor: Int) {
        mProgressColor = progressColor
    }

    fun setBarColor(barColor: Int) {
        mBarColor = barColor
    }

    @Synchronized
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mDrawListener!!.onReady()
        // Draw rect bounds
        paint.setAntiAlias(true)
        paint.setColor(mBarColor)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeWidth(2F)

        selectedPaint.setAntiAlias(true)
        selectedPaint.setColor(mProgressColor)
        selectedPaint.setStyle(Paint.Style.STROKE)
        selectedPaint.setStrokeWidth(2F)

        // Draw rest of the circle'Bounds
        for (i in mThumbContainerXPosition.indices) {
            canvas.drawCircle(
                mThumbContainerXPosition.get(i), mCenterY, mCircleRadius,
                if (i <= mCompletedPosition) selectedPaint else paint
            )
        }

        paint.setStyle(Paint.Style.FILL)
        selectedPaint.setStyle(Paint.Style.FILL)
        for (i in 0 until mThumbContainerXPosition.size - 1) {
            val pos = mThumbContainerXPosition.get(i)
            val pos2 = mThumbContainerXPosition.get(i + 1)
            canvas.drawRect(
                pos, mLeftY, pos2, mRightY,
                if (i < mCompletedPosition) selectedPaint else paint
            )
        }

        // Draw rest of circle
        for (i in mThumbContainerXPosition.indices) {
            val pos = mThumbContainerXPosition.get(i)
            canvas.drawCircle(
                pos, mCenterY, mCircleRadius,
                if (i <= mCompletedPosition) selectedPaint else paint
            )

            if (i == mCompletedPosition) {
                selectedPaint.color = getColorWithAlpha(
                    mProgressColor,
                    0.2f
                )
                canvas.drawCircle(pos, mCenterY, mCircleRadius * 1.8f, selectedPaint)
            }
        }
    }

    interface OnDrawListener {

        fun onReady()
    }

    companion object {

        private val THUMB_SIZE = 100

        fun getColorWithAlpha(color: Int, ratio: Float): Int {
            var newColor = 0
            val alpha = Math.round(Color.alpha(color) * ratio)
            val r = Color.red(color)
            val g = Color.green(color)
            val b = Color.blue(color)
            newColor = Color.argb(alpha, r, g, b)
            return newColor
        }
    }
}
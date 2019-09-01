package com.example.infrastructure.view.widgets

import android.annotation.TargetApi
import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Build
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet

import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.infrastructure.R


class CategoryView : LinearLayout {

    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr)

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes)

     var titleCategory: TextView
     var descriptionCategory: TextView
     var cardCategory: CoordinatorLayout
     var imageCategory: ImageView
     var numberSupplier : TextView
     lateinit var mListener : OnClickCategoryView
     lateinit var id  : String
     var relativeLayoutNumberSuppliers : RelativeLayout

        init {
            LayoutInflater.from(context)
                .inflate(R.layout.category_view, this, true)

            orientation = VERTICAL
            titleCategory = findViewById(R.id.titleCategory)
            descriptionCategory = findViewById(R.id.descriptionCategory)
            imageCategory = findViewById(R.id.imageCategory)
            cardCategory = findViewById(R.id.cardCategory)
            numberSupplier = findViewById(R.id.numberSupplier)
            relativeLayoutNumberSuppliers = findViewById(R.id.relativeLayoutNumberSuppliers)

            cardCategory.setOnClickListener {
                mListener.onClick(this)
            }
        }

    /**
     * function that change the color of the background card
     */
    fun changeColorOfCard(color: Int){
       var gradientDrawable: GradientDrawable = cardCategory.background.mutate() as GradientDrawable
        gradientDrawable.setColor(color)
    }

    fun setTitle(title : String){
        titleCategory.text = title
    }


    fun setDescription(description : String){
        descriptionCategory.text = description
    }

    fun setNumberSupplier(message : String){
        descriptionCategory.text = message
    }

    fun setWidthAndHeight(width: Int , height:Int){
        cardCategory.layoutParams.width = width
        cardCategory.layoutParams.height = height
    }
    fun setHeight(height: Int){
        cardCategory.layoutParams.height = height
    }

    /**
     * align right the view that show the number of suppliers
     */
    fun alignRightNumberSuppliers(){
        val layout = findViewById(R.id.layoutCategory) as ConstraintLayout
        val constraintSet = ConstraintSet()
        constraintSet.clone(layout)
        constraintSet.setHorizontalBias(R.id.relativeLayoutNumberSuppliers, 0.98f)
        constraintSet.applyTo(layout)
    }

    /**
     * align left the description text view
     */
    fun alignLeftTextDescription(){
        val layout = findViewById(R.id.layoutCategory) as ConstraintLayout
        val constraintSet = ConstraintSet()
        constraintSet.clone(layout)
        constraintSet.connect(R.id.descriptionCategory,ConstraintLayout.TEXT_ALIGNMENT_VIEW_END,R.id.imageCategory,ConstraintLayout.TEXT_ALIGNMENT_VIEW_END)
        constraintSet.setHorizontalBias(R.id.descriptionCategory, 0.4f)
        constraintSet.applyTo(layout)
    }

    fun setImageCategory(url : Uri){
        imageCategory.setImageURI(url)
    }

    fun setImageCategory(drawable: Drawable){
        imageCategory.setImageDrawable(drawable)
    }

    fun setImageCategory(resource : Int){
        imageCategory.setImageResource(resource)
    }

    fun setVisibilityTitle(vis :Int){
        titleCategory.visibility =vis
    }

    fun setVisibilityDescription(vis :Int){
        descriptionCategory.visibility =vis
    }

    fun setVisibilityImageCategory(vis :Int){
        imageCategory.visibility =vis
    }

    interface OnClickCategoryView{
        fun onClick(categoryView: CategoryView)
    }
}
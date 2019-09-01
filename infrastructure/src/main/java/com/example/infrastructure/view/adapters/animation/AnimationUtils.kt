package com.example.infrastructure.view.adapters.animation

import android.support.v7.widget.RecyclerView
import android.view.animation.AnimationUtils
import com.example.infrastructure.R
import com.example.infrastructure.view.adapters.BaseAdapter


class AnimationUtils<T>(var typeAnimation: TypeAnimation, var recyclerView: RecyclerView, var adapter : BaseAdapter<T>) {


    /**
     * run the animation according to animation type
     */
    fun playAnimation(){
        when (typeAnimation) {
            TypeAnimation.FROM_BOTTOM -> runLayoutAnimationFromBottom()
            TypeAnimation.FROM_RIGHT -> runLayoutAnimationFromRight()
            TypeAnimation.FALL_DOWN -> runLayoutAnimationFallDown()
        }
    }

    /**
     *  execute slide from bottom animation
     */
    fun runLayoutAnimationFromBottom() {
        val context = recyclerView.context
        val controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_from_bottom)
        recyclerView.layoutAnimation = controller
        adapter.notifyDataSetChanged()
        recyclerView.scheduleLayoutAnimation()
    }
    /**
     *  execute slide from right animation
     */
    private fun runLayoutAnimationFromRight() {
        val context = recyclerView.context
        val controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_from_right)
        recyclerView.layoutAnimation = controller
        adapter.notifyDataSetChanged()
        recyclerView.scheduleLayoutAnimation()
    }

    /**
     *  execute fall down animation
     */
    private fun runLayoutAnimationFallDown() {
        val context = recyclerView.context
        val controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_fall_down)
        recyclerView.layoutAnimation = controller
        adapter.notifyDataSetChanged()
        recyclerView.scheduleLayoutAnimation()
    }

    /**
     * Define the type of the animations
     */
    enum class TypeAnimation {
        FROM_BOTTOM, FROM_RIGHT, FALL_DOWN
    }
}
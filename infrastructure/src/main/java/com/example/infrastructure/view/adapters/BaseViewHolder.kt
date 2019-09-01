package com.example.infrastructure.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.View

abstract open class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView){

    /**
     * binding the object item to the view
     * @param itemObject
     *
     */
    abstract fun bindView(itemObject : T)
}
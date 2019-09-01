package com.example.infrastructure.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.util.*


abstract class BaseAdapter<T>(var mList: ArrayList<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    abstract fun onBindHolder(holder: RecyclerView.ViewHolder, position: Int)
    abstract fun onCreateHolder(view: ViewGroup, type: Int) : RecyclerView.ViewHolder

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
         onBindHolder(p0,p1)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return onCreateHolder(p0,p1)
    }

    /**
     *  remove the item from the recycleview
     */
    fun removeItem(position : Int){
        mList.remove(mList.get(position))
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, mList.size)
    }

    /**
     *  add the item to recycleview
     */
    fun addItem(item : T){
        mList.add(item)
        notifyDataSetChanged()
    }

    /**
     * Inserts new data to the adapter.
     *
     * @param data - List of objects to be inserted to the adapter.
     */
    fun setData(data: List<T>) {
        for (t in data) {
            addItem(t)
        }
    }

    /**
     * clear the list of the adapter
     */
    fun clear() {
        mList.clear()
        notifyDataSetChanged()
    }

    /**
     * add items to list
     */
    fun addItems(items: List<T>) {
        mList.addAll(items)
    }

    /**
     * @return the list of the adapter
     */
    fun getData(): List<T> {
        return mList
    }

    /**
     * Adds a new list of items to the existing data and notifies the view in an explicit method
     * @param items - new list of items to be inserted to the existing data
     */
    fun addAll(items: List<T>) {
        mList.addAll(items)
        notifyDataSetChanged()
    }
}
package com.example.tavorcohen.recycleviewexample.publishRequest.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.infrastructure.view.adapters.BaseAdapter
import com.example.infrastructure.view.adapters.BaseViewHolder
import com.example.tavorcohen.recycleviewexample.R
import com.wefixapp.wefixisr.v2.view.utils.ImageUtils
import kotlinx.android.synthetic.main.base_header_layout.view.*
import java.util.*

class SubcategoryAdapter(private var mSubCategorylist: ArrayList<SubcategoryItem>,private var mListener : ISubcategoryAdapter,private var context: Context)  : BaseAdapter<SubcategoryItem>(mSubCategorylist) {



    override fun onCreateHolder(view: ViewGroup, type: Int): RecyclerView.ViewHolder {
        return SubCategoryViewHolder(
            LayoutInflater.from(view.context)
                .inflate(R.layout.row_subcategory, view, false) )

    }

    override fun onBindHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mSubCategorylist[position]
        (holder as SubCategoryViewHolder).bindView ((item))

        holder.itemView.setOnClickListener {
            mListener.onClickListener(it,item)
        }
        ImageUtils.configureForLeftToRight(context.resources,holder.itemView.findViewById(R.id.imageArrow),-1f)
    }

    /**
     * The first item that include one card of category
     */
    class SubCategoryViewHolder(itemView: View) : BaseViewHolder<SubcategoryItem>(itemView){

        /**
         * bind the data to view
         */
        override fun bindView(subCategory: SubcategoryItem) {
            itemView.findViewById<TextView>(R.id.subCategoryTitle).text = subCategory.title
            itemView.findViewById<TextView>(R.id.subCategoryDescription).text = subCategory.description


        }
    }

    interface ISubcategoryAdapter{
       fun onClickListener(view : View,subCategory: SubcategoryItem)
    }
}
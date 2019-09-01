package com.example.infrastructure.view.adapters.category

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.infrastructure.R
import com.example.infrastructure.view.adapters.BaseAdapter
import com.example.infrastructure.view.adapters.BaseViewHolder
import com.example.infrastructure.view.widgets.CategoryView

import java.util.*


class CategoryAdapter(var categoryList: ArrayList<CategoryCards>)  : BaseAdapter<CategoryCards>(categoryList){

    override fun onCreateHolder(view: ViewGroup, type: Int): RecyclerView.ViewHolder {
        when (type){
            TYPE_ONE -> return OneCategoryViewHolder(
                LayoutInflater.from(view.context)
                    .inflate(R.layout.one_category_item, view, false)
            )
            TYPE_TWO -> return TwoCategoryViewHolder(
                LayoutInflater.from(view.context)
                    .inflate(R.layout.two_category_item, view, false)
            )
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val row = categoryList.get(position)
        when (holder.itemViewType) {
            TYPE_ONE -> (holder as OneCategoryViewHolder).bindView ((row))
            TYPE_TWO -> (holder as TwoCategoryViewHolder).bindView ((row))
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (categoryList[position].listCards.size) {
            1 -> TYPE_ONE
            2 -> TYPE_TWO
            else -> throw IllegalArgumentException()
        }

    /**
     * The first item that include one card of category
     */
    class OneCategoryViewHolder(itemView: View) : BaseViewHolder<CategoryCards>(itemView){

        /**
         * bind the data to view
         */
       override fun bindView(cards: CategoryCards) {
            val category1 = cards.listCards.get(0)
            if( cards.listCards.size==1){
                itemView.findViewById<CategoryView>(R.id.cardOne)
                itemView.findViewById<CategoryView>(R.id.cardOne).titleCategory.text = category1.title
                itemView.findViewById<CategoryView>(R.id.cardOne).descriptionCategory.text = category1.description
                itemView.findViewById<CategoryView>(R.id.cardOne).numberSupplier.text = category1.numberSupplier
                itemView.findViewById<CategoryView>(R.id.cardOne).changeColorOfCard(category1.color)
                itemView.findViewById<CategoryView>(R.id.cardOne).id = category1.id!!
                itemView.findViewById<CategoryView>(R.id.cardOne).mListener = category1.listener
                itemView.findViewById<CategoryView>(R.id.cardOne).setHeight(category1.height)
                itemView.findViewById<CategoryView>(R.id.cardOne).alignRightNumberSuppliers()
            }
        }
    }

    /**
     * The second item that include two cards of category
     */
    class TwoCategoryViewHolder(itemView: View) : BaseViewHolder<CategoryCards>(itemView){

        /**
         * bind the data to view
         */
        override fun bindView(cards: CategoryCards) {
                val category1 =  cards.listCards.get(0)
                val category2 =  cards.listCards.get(1)

            itemView.findViewById<CategoryView>(R.id.cardOne).titleCategory.text = category1.title
            itemView.findViewById<CategoryView>(R.id.cardOne).descriptionCategory.text = category1.description
            itemView.findViewById<CategoryView>(R.id.cardOne).numberSupplier.text = category1.numberSupplier
            itemView.findViewById<CategoryView>(R.id.cardOne).changeColorOfCard(category1.color)
            itemView.findViewById<CategoryView>(R.id.cardOne).id = category1.id!!
            itemView.findViewById<CategoryView>(R.id.cardOne).mListener = category1.listener
            itemView.findViewById<CategoryView>(R.id.cardOne).setHeight(category1.height)
            itemView.findViewById<CategoryView>(R.id.cardOne).alignLeftTextDescription()

            itemView.findViewById<CategoryView>(R.id.cardTwo).titleCategory.text = category2.title
            itemView.findViewById<CategoryView>(R.id.cardTwo).descriptionCategory.text = category2.description
            itemView.findViewById<CategoryView>(R.id.cardTwo).numberSupplier.text = category2.numberSupplier
            itemView.findViewById<CategoryView>(R.id.cardTwo).changeColorOfCard(category2.color)
            itemView.findViewById<CategoryView>(R.id.cardTwo).id = category2.id!!
            itemView.findViewById<CategoryView>(R.id.cardTwo).mListener = category2.listener
            itemView.findViewById<CategoryView>(R.id.cardTwo).setHeight(category2.height)
            itemView.findViewById<CategoryView>(R.id.cardTwo).alignLeftTextDescription()
        }
    }

    /**
     * static members that define the types of the items
     */
    companion object {
        private const val TYPE_ONE = 1
        private const val TYPE_TWO = 2
    }

}
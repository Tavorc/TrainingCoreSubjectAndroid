package com.example.tavorcohen.recycleviewexample.publishRequest.view.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.infrastructure.view.adapters.animation.AnimationUtils
import com.example.tavorcohen.recycleviewexample.R
import com.example.tavorcohen.recycleviewexample.publishRequest.view.activity.PublishRequestActivity
import com.example.tavorcohen.recycleviewexample.publishRequest.view.adapter.SubcategoryAdapter
import com.example.tavorcohen.recycleviewexample.publishRequest.view.adapter.SubcategoryItem

class PublishRequestStep2Fragment : BaseFragment(), PublishRequestActivity.IPublishRequestStep2,
    SubcategoryAdapter.ISubcategoryAdapter {
    override fun onLand() {
        animationUtils.playAnimation()
    }


    private lateinit var mIdCategory: String
    lateinit var mRecyclerViewSubCategory : RecyclerView
    lateinit var  mAdapterSubCategory : SubcategoryAdapter
    var mListSubCategories = arrayListOf<SubcategoryItem>()


    lateinit var animationUtils : AnimationUtils<SubcategoryItem>
    companion object{
        const val ID_CATEGORY = "id_category"
        fun newInstance():PublishRequestStep2Fragment{
            val args: Bundle = Bundle()
            val fragment = PublishRequestStep2Fragment()
            fragment.arguments = args

            return fragment
        }
    }

    override fun initView(view: ViewGroup) {
        mRecyclerViewSubCategory = view.findViewById(R.id.recycleViewSubcategory)
        mRecyclerViewSubCategory.layoutManager = LinearLayoutManager(activity)
        initList()
        mAdapterSubCategory = SubcategoryAdapter(mListSubCategories,this, activity!!)

        // initialize the animationUtils instance
        animationUtils = AnimationUtils(AnimationUtils.TypeAnimation.FROM_RIGHT,mRecyclerViewSubCategory, mAdapterSubCategory)
        mRecyclerViewSubCategory.adapter = mAdapterSubCategory

    }

    private fun initList() {
        mListSubCategories.add( SubcategoryItem("1","עבודות צבע",resources.getString(R.string.desription_example_subtitle)))
        mListSubCategories.add( SubcategoryItem("2","עבודות צבע",resources.getString(R.string.desription_example_subtitle)))
        mListSubCategories.add( SubcategoryItem("3","עבודות צבע",resources.getString(R.string.desription_example_subtitle)))
        mListSubCategories.add( SubcategoryItem("4","עבודות צבע",resources.getString(R.string.desription_example_subtitle)))
        mListSubCategories.add( SubcategoryItem("5","עבודות צבע",resources.getString(R.string.desription_example_subtitle)))
        mListSubCategories.add( SubcategoryItem("6","עבודות צבע",resources.getString(R.string.desription_example_subtitle)))
        mListSubCategories.add( SubcategoryItem("7","עבודות צבע",resources.getString(R.string.desription_example_subtitle)))
        mListSubCategories.add( SubcategoryItem("8","עבודות צבע",resources.getString(R.string.desription_example_subtitle)))
        mListSubCategories.add( SubcategoryItem("9","עבודות צבע",resources.getString(R.string.desription_example_subtitle)))
        mListSubCategories.add( SubcategoryItem("10","עבודות צבע",resources.getString(R.string.desription_example_subtitle)))
    }

    override fun getLayout(): Int {
        return R.layout.fragment_publish_request_step2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity as (PublishRequestActivity)).mListenerStep2 =this
    }

    override fun onClickListener(view: View, subCategory: SubcategoryItem) {

        (activity as (PublishRequestActivity)).moveToPage3(2, subCategory.id!!)
    }



    override fun onDataReceived(idCategory: String) {
        mIdCategory = idCategory
    }

}
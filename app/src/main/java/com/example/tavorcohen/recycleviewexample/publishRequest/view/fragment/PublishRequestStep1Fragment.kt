package com.example.tavorcohen.recycleviewexample.publishRequest.view.fragment

import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.infrastructure.view.adapters.animation.AnimationUtils
import com.example.infrastructure.view.adapters.category.Category
import com.example.infrastructure.view.adapters.category.CategoryAdapter
import com.example.infrastructure.view.adapters.category.CategoryCards
import com.example.infrastructure.view.widgets.CategoryView
import com.example.tavorcohen.recycleviewexample.R
import com.example.tavorcohen.recycleviewexample.publishRequest.view.activity.PublishRequestActivity as PublishRequestActivity1
import com.example.tavorcohen.recycleviewexample.publishRequest.view.activity.PublishRequestActivity

class PublishRequestStep1Fragment : BaseFragment(), CategoryView.OnClickCategoryView,
    PublishRequestActivity.IPublishRequestStep1 {
    override fun onBackClick() {
        animationUtils.playAnimation()
    }

    override fun getLayout(): Int {
    return R.layout.fragment_publish_request_step1
    }


    override fun onClick(categoryView: CategoryView) {
        (activity as (PublishRequestActivity)).moveToPage2(1,categoryView.id)
    }

    lateinit var mRecyclerViewCategory : RecyclerView
    lateinit var  mAdapterCategory : CategoryAdapter
    var mListCategories = arrayListOf<CategoryCards>()
    var count = 0
    var countColor = 0
    var flagCountFour = false
    lateinit var animationUtils : AnimationUtils<CategoryCards>

    companion object{
            fun newInstance():PublishRequestStep1Fragment{
                val args: Bundle = Bundle()
                val fragment = PublishRequestStep1Fragment()
                fragment.arguments = args
                return fragment
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onResume() {
        super.onResume()
        animationUtils.playAnimation()

    }


    override fun initView(view: ViewGroup){

        mRecyclerViewCategory = view.findViewById(R.id.recycleViewCategory)
        mRecyclerViewCategory.layoutManager = LinearLayoutManager(activity)
        initList()
        mAdapterCategory = CategoryAdapter(mListCategories)
        // initialize the animationUtils instance
        animationUtils = AnimationUtils(AnimationUtils.TypeAnimation.FROM_BOTTOM,mRecyclerViewCategory, mAdapterCategory)
        mRecyclerViewCategory.adapter = mAdapterCategory
        //execute the animation
        animationUtils.playAnimation()
        (activity as (PublishRequestActivity)).mListenerStep1 =this
    }


    /**
     * initialize the list of Row
     */
    private fun initList(){
        var colorList = arrayListOf(R.color.azure, R.color.blue, R.color.green,R.color.yellow,R.color.red)
        for (item in 1 until  22){
            var listTemp : ArrayList<Category> = ArrayList()
            lateinit var cardsListTemp : CategoryCards
            count++

            /**
             * create OneCard object and add it to the list
             */
            if(count>0 && count<3){
                var category1 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Category(
                        item.toString(),
                        getString(R.string.handiman),
                        getString(R.string.description),
                        "gdfgdfgdfgdfg",
                        "2000 " + getString(R.string.number_supplier),
                        false,
                        resources.getColor(colorList[countColor]),
                        this,
                        550
                    )

                } else {
                    TODO("VERSION.SDK_INT < M")
                }
                listTemp.add(category1)
                cardsListTemp = CategoryCards(listTemp)
                mListCategories.add(cardsListTemp)
            }
            /**
             * create the TwoCards object and add it to the list
             */
            else{
                if(countColor==4){
                    countColor = 0
                    flagCountFour =true
                }
                var category2 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Category(
                        item.toString(),
                        getString(R.string.handiman),
                        getString(R.string.description),
                        "gdfgdfgdfgdfg",
                        getString(R.string.new_str),
                        false,
                       resources.getColor(colorList[countColor]),
                        this,
                        700
                    )
                } else {
                    TODO("VERSION.SDK_INT < M")
                }

                var secondIndex = (item+1).toString()
                var category3 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Category(
                        secondIndex,
                        getString(R.string.handiman),
                        getString(R.string.description),
                        "gdfgdfgdfgdfg",
                        getString(R.string.new_str),
                        false,
                        resources.getColor(colorList[++countColor]),
                        this,
                        700
                    )
                } else {
                    TODO("VERSION.SDK_INT < M")
                }

                listTemp.add(category2)
                listTemp.add(category3)
                cardsListTemp = CategoryCards(listTemp)
                mListCategories.add(cardsListTemp)


            }

            if(countColor==4){
                countColor = 0
                flagCountFour =true
            }
            countColor++
            if(flagCountFour){
                countColor = 0
                flagCountFour = false
            }

            if(count==3){
                count=0
            }
        }
    }
}
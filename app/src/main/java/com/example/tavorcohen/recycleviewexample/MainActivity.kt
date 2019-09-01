package com.example.tavorcohen.recycleviewexample

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.infrastructure.view.adapters.animation.AnimationUtils
import com.example.infrastructure.view.adapters.category.Category
import com.example.infrastructure.view.adapters.category.CategoryAdapter
import com.example.infrastructure.view.adapters.category.CategoryCards
import com.example.infrastructure.view.widgets.CategoryView
import com.example.tavorcohen.recycleviewexample.customNotification.fcm.FcmUtils
import com.example.tavorcohen.recycleviewexample.customNotification.fcm.SubscribeTopic
import com.example.tavorcohen.recycleviewexample.customNotification.notificationService.ShowNotificationIntentService

class MainActivity : AppCompatActivity(), CategoryView.OnClickCategoryView {

    /**
     * event listener when the user click on one category
     */
    override fun onClick(categoryView: CategoryView) {
        Log.d("id Cusss ",categoryView.id)

    }

    lateinit var mRecyclerViewCategory : RecyclerView
    lateinit var  mAdapterCategory : CategoryAdapter
    var mListCategories = arrayListOf<CategoryCards>()
    var count = 0
    var countColor = 0
    var flagCountFour = false
    lateinit var animationUtils : AnimationUtils<CategoryCards>
    lateinit var subsribeSupplier : SubscribeTopic
    companion object {
        const val HANDIMAN: String = "handiman"
    }

    //lateinit var notificationBuilder : NotificationBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

    private fun initView(){

        mRecyclerViewCategory = findViewById(R.id.recycleViewCategory)
        mRecyclerViewCategory.setLayoutManager(LinearLayoutManager(this))
        initList()
        mAdapterCategory = CategoryAdapter(mListCategories)
        // initialize the animationUtils instance
        animationUtils = AnimationUtils(AnimationUtils.TypeAnimation.FROM_BOTTOM,mRecyclerViewCategory, mAdapterCategory)
        mRecyclerViewCategory.setAdapter(mAdapterCategory)
        //execute the animation
        animationUtils.playAnimation()


    }

    override fun onResume() {
        super.onResume()
        FcmUtils.handleFcmToken(this)
        subsribeSupplier = SubscribeTopic(HANDIMAN)
        subsribeSupplier.subcribeToTopic()
        animationUtils.playAnimation()

        ShowNotificationIntentService.startActionHide(applicationContext)

    }

    override fun onPause() {
        super.onPause()
        ShowNotificationIntentService.startActionShow(applicationContext)
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
                        getColor(colorList[countColor]),
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
                        getColor(colorList[countColor]),
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
                        getColor(colorList[++countColor]),
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



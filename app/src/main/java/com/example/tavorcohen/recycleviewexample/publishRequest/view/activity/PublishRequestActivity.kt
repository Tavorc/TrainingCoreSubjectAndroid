package com.example.tavorcohen.recycleviewexample.publishRequest.view.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.view.View.GONE
import com.ToxicBakery.viewpager.transforms.AccordionTransformer
import com.example.tavorcohen.recycleviewexample.R
import com.example.tavorcohen.recycleviewexample.view.button.BaseBigButton
import com.example.tavorcohen.recycleviewexample.view.header.BaseHeader
import com.example.tavorcohen.recycleviewexample.view.header.OnBackClick
import com.example.tavorcohen.recycleviewexample.publishRequest.view.adapter.PublishRequestPagerAdapter
import kotlinx.android.synthetic.main.activity_publish_request.*


open class PublishRequestActivity : BaseActivity(), BaseBigButton.BaseBigButton, OnBackClick {

    lateinit var mListenerStep1 : IPublishRequestStep1
    lateinit var mListenerStep2 : IPublishRequestStep2
    lateinit var mIdCategory : String
    lateinit var mIdSubcategory : String
    lateinit var mViewPager : ViewPager
    lateinit var mVerificationAdapterViewPager : PublishRequestPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publish_request)
        initView()
        updateUiStep1()
        setListeners()
    }

    private fun initView(){
        mViewPager= findViewById(R.id.viewpager)
        mVerificationAdapterViewPager = PublishRequestPagerAdapter(supportFragmentManager)
        mViewPager.adapter = mVerificationAdapterViewPager
        mViewPager.setPageTransformer(true, AccordionTransformer())
        mViewPager.setOnTouchListener(View.OnTouchListener { v, event -> true })
    }


    private fun setListeners(){
        nextButton.mListener = this
        header.mListener =this
    }


    /**
     *  call when the user click on the back button in the header
     */
    override fun onBack(baseHeader: BaseHeader) {
        when(mViewPager.currentItem){
            0 ->{
                finish()
            }
            1->{
                mListenerStep1.onBackClick()
                updateUiStep1()
                mViewPager.currentItem = 0
            }
            2->{
                updateUiStep2()
                mViewPager.currentItem = 1
            }
            3->{
                mViewPager.currentItem = 2
            }
        }
    }

    /**
     * when the user click on the big button
     */
    override fun onClickBigButton(baseBigButton: View) {
        when(mViewPager.currentItem){

            0 ->{
                mViewPager.currentItem = 1
                return
            }

            1->{
                mViewPager.currentItem = 2
                return
            }
            2->{
                mViewPager.currentItem = 3
                return
            }
            3->{
                finish()
                return
            }
        }
    }


     fun moveToPage2(number : Int,idCategory : String){
        mListenerStep2.onLand()
        updateUiStep2(idCategory)
        mListenerStep2.onDataReceived(idCategory)
        mViewPager.currentItem = number
    }

    fun moveToPage3(number : Int,idSubcategory : String){
        updateUiStep3()
        mIdSubcategory=idSubcategory
        mViewPager.currentItem = number
    }

    private fun updateUiStep1(){
        header.setTitle(resources.getString(R.string.open_new_request))
        header.setBackgroundHeader(resources.getColor(R.color.bg_header_category))
        header.setTitleColor(resources.getColor(R.color.title_category_header))
        header.setColorBackButton(resources.getColor(R.color.azure))
        nextButton.visibility = GONE
        nextButton.setButtonText(resources.getString(R.string.next))
        header.setTitle(resources.getString(R.string.open_new_request))
    }

    private fun updateUiStep2(idCategory: String){
        mIdCategory = idCategory
        nextButton.visibility = View.GONE
        header.setBackgroundHeader(resources.getColor(R.color.primary_blue))
        header.setTitleColor(resources.getColor(R.color.title))
        header.setColorBackButton(resources.getColor(R.color.white))
        setTitleHeader(idCategory)
        mListenerStep2.onLand()
    }

    private fun updateUiStep2(){
        nextButton.visibility = View.GONE
        header.setBackgroundHeader(resources.getColor(R.color.primary_blue))
        header.setTitleColor(resources.getColor(R.color.title))
        header.setColorBackButton(resources.getColor(R.color.white))
        mListenerStep2.onLand()
    }

    private fun updateUiStep3(){
        nextButton.visibility = View.VISIBLE
        header.setBackgroundHeader(resources.getColor(R.color.primary_blue))
        header.setTitleColor(resources.getColor(R.color.title))
        header.setColorBackButton(resources.getColor(R.color.white))

    }

    private fun setTitleHeader(idCategory: String){

        when(idCategory){
            "1" ->{
                header.setTitle(resources.getString(R.string.request_handiman))
            }
        }
    }

    interface IPublishRequestStep1 {
        fun onBackClick()
    }

    interface IPublishRequestStep2 {
        fun onLand()
        fun onDataReceived(idCategory : String)
    }
}

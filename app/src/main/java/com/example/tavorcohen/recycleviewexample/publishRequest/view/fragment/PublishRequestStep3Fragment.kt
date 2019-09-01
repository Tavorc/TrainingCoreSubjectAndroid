package com.example.tavorcohen.recycleviewexample.publishRequest.view.fragment

import android.os.Bundle
import android.view.ViewGroup
import com.example.tavorcohen.recycleviewexample.R

class PublishRequestStep3Fragment: BaseFragment() {

    companion object{
        fun newInstance():PublishRequestStep3Fragment{
            val args: Bundle = Bundle()
            val fragment = PublishRequestStep3Fragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun initView(view: ViewGroup) {

    }

    override fun getLayout(): Int {
        return R.layout.fragment_publish_request_step3
    }
}
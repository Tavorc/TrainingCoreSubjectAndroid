package com.example.tavorcohen.recycleviewexample.publishRequest.view.fragment
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {

    protected lateinit var mRootView: ViewGroup

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(getLayout(), container, false) as ViewGroup
        initView(mRootView)
        return mRootView
    }

    /**
     * Inflates the given layout and calls initView(View layout)
     *
     * @return The layout resource id to inflate on this fragment
     */
    abstract fun getLayout(): Int

    /**
     * Called after the layout resource passed in by getLayout()
     * is inflated.
     * This is where view initialization should occur.
     *
     * @param view The layout for this fragment
     */
    abstract fun initView(view: ViewGroup)

}
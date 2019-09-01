package com.example.tavorcohen.recycleviewexample.publishRequest.view.fragment

import android.content.ContentUris
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.tavorcohen.recycleviewexample.R


class PublishRequestStep4Fragment : BaseFragment() {

    private lateinit var mGradientDrawable : GradientDrawable
    lateinit var mRadioTomorrow : RadioButton
    lateinit var mRadioToday : RadioButton
    private lateinit var mRadioDate : RadioButton
    private lateinit var mRadioGroupDate : RadioGroup
    private lateinit var mMorningCheckbox : CheckBox
    private lateinit var mNoonCheckbox : CheckBox
    private lateinit var mEveningCheckbox : CheckBox

    companion object{
        fun newInstance():PublishRequestStep4Fragment{
            val args: Bundle = Bundle()
            val fragment = PublishRequestStep4Fragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_publish_request_step4
    }



    override fun initView(view: ViewGroup) {

        mRadioTomorrow = view.findViewById(R.id.radioTomorrow)
        mRadioToday = view.findViewById(R.id.radioToday)
        mRadioDate = view.findViewById(R.id.radioDate)
        mRadioGroupDate = view.findViewById(R.id.radioGroupDate)
        mMorningCheckbox = view.findViewById(R.id.morningCheckbox)
        mNoonCheckbox = view.findViewById(R.id.noonCheckbox)
        mEveningCheckbox = view.findViewById(R.id.eveningCheckbox)

        mGradientDrawable = GradientDrawable()
        designRadioButtonDate()
        setListenerRadioGroup(view)
    }

    private fun setListenerRadioGroup(view: ViewGroup){
        mRadioGroupDate.setOnCheckedChangeListener { group, checkedId ->
            var radio: RadioButton = view.findViewById(checkedId)
            val index = mRadioGroupDate.indexOfChild(radio)


            when (index) {
                0
                ->{
                    Log.d("tagg","0")
                }
                1
                ->{
                    Log.d("tagg","0")
                }
                2->{
                    openCalendar()
                }
            }
        }
    }

    private fun openCalendar(){

        val builder: Uri.Builder = CalendarContract.CONTENT_URI.buildUpon()
            .appendPath("time")

        val intent = Intent(Intent.ACTION_VIEW)
            .setData(builder.build())
        startActivity(intent)
    }
  private fun designRadioButtonDate(){
      val color1 = resources.getColor(R.color.frame_radio_button_color)
      mGradientDrawable.cornerRadius = 5f
      mGradientDrawable.setStroke(2,color1)
      mGradientDrawable.shape = GradientDrawable.RECTANGLE
      mRadioTomorrow.background = mGradientDrawable
      mRadioToday.background = mGradientDrawable
      mRadioDate.background = mGradientDrawable

      mMorningCheckbox.background = mGradientDrawable
      mNoonCheckbox.background = mGradientDrawable
      mEveningCheckbox.background = mGradientDrawable

  }

}
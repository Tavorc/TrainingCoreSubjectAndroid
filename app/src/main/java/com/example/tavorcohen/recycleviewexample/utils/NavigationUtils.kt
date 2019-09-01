package com.wefixapp.wefixisr.v2.view.utils

import android.app.Activity
import android.content.Intent

class NavigationUtils {

    companion object{
       const val SOURCE_SMS_VERIFICATION : String ="source_sms_verification"


        fun <T : Activity> navigateBetweenActivity(activity: Activity, activityToOpen: Class<T>, close: Boolean) {
            val intent = Intent(activity, activityToOpen)
            activity.startActivity(intent)
            if (close) {
                activity.finish()
            }
        }


        fun <T : Activity> navigateToSmsVerification(activity: Activity, activityToOpen: Class<T>, sourceToVerification : String, close: Boolean) {
            val intent = Intent(activity, activityToOpen)
            intent.putExtra(SOURCE_SMS_VERIFICATION, sourceToVerification)
            activity.startActivity(intent)
            if (close) {
                activity.finish()
            }
        }


        fun <T : Activity> navigateToEnterUserNameActivity(activity: Activity, activityToOpen: Class<T>, sourceToVerification : String, close: Boolean) {
            val intent = Intent(activity, activityToOpen)
            intent.putExtra(SOURCE_SMS_VERIFICATION, sourceToVerification)
            activity.startActivity(intent)
            if (close) {
                activity.finish()
            }
        }
    }





}
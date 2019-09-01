package com.example.tavorcohen.recycleviewexample.customNotification.fcm

import android.app.Activity

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging

class FcmUtils {

    companion object {
        const val TAG: String = "FcmUtils"
        const val SUPPLIER: String = "supplier"

        /**
         * get token from firebase
         * @param Activity
         */
        fun handleFcmToken(activity: Activity) {
            FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener(activity) { instanceIdResult ->
                val newToken = instanceIdResult.token
            }
        }
    }
}
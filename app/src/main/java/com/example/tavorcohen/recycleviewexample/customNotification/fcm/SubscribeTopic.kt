package com.example.tavorcohen.recycleviewexample.customNotification.fcm

import android.util.Log
import com.example.tavorcohen.recycleviewexample.customNotification.fcm.FcmUtils
import com.google.firebase.messaging.FirebaseMessaging


class SubscribeTopic(var topic:String = FcmUtils.SUPPLIER)  {

    /**
     * Unsubscribe by topic
     */
     fun unsubscribeToTopic() {
        FirebaseMessaging.getInstance().unsubscribeFromTopic(topic)
    }

    /**
     * subscribe to some topic for sending notifications
     */
     fun subcribeToTopic() {
        FirebaseMessaging.getInstance().subscribeToTopic(topic)
            .addOnCompleteListener { task ->
                var msg = "Succes"
                if (!task.isSuccessful) {
                    msg = "error"
                }
                Log.d(FcmUtils.TAG, msg)
            }
    }
}
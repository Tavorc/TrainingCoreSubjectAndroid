package com.example.tavorcohen.recycleviewexample.customNotification.fcm

import android.net.Uri
import android.util.Log
import com.example.tavorcohen.recycleviewexample.customNotification.fcm.FcmUtils.Companion.SUPPLIER
import com.example.tavorcohen.recycleviewexample.customNotification.notificationType.DefaultNotification
import com.example.tavorcohen.recycleviewexample.customNotification.notificationType.NotificationStrategy
import com.example.tavorcohen.recycleviewexample.customNotification.notificationType.SupplierNotification
import com.example.tavorcohen.recycleviewexample.customNotification.notificationType.UserNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyServiceFirebaseNotification : FirebaseMessagingService() {
    private val TAG = "MyInstanceIdService"
    companion object {
        const val HANDIMAN: String = "handiman"
        const val TOPIC: String = "/topics/"
        const val USER: String = "user"
        const val ALL_TYPES: String = "all_type"
    }

    override fun onNewToken(s: String?) {
        Log.d(TAG, "onNewToken: s: " + s!!)
        super.onNewToken(s)
    }

    /**
     * get the message from server and push the appropriate notification
     * @param RemoteMessage
     */
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Log.d(TAG, "onMessageReceived: ")
        super.onMessageReceived(remoteMessage)
        val imageUrl = Uri.parse("https://i.ibb.co/NCprzQc/cat.jpg")
        var notificationStrategy: NotificationStrategy

        /**
         * push notification according to topic
         */
        when(remoteMessage!!.from){

            TOPIC + SUPPLIER -> {
                notificationStrategy = SupplierNotification(ALL_TYPES,imageUrl,baseContext)
                notificationStrategy.buildNotification(remoteMessage)
            }
            TOPIC + HANDIMAN -> {
                notificationStrategy = SupplierNotification(HANDIMAN,imageUrl,baseContext)
                notificationStrategy.buildNotification(remoteMessage)
            }

            TOPIC + USER -> {
                notificationStrategy = UserNotification(imageUrl,baseContext)
                notificationStrategy.buildNotification(remoteMessage)
            }
           else -> {
               notificationStrategy = DefaultNotification(imageUrl,baseContext)
               notificationStrategy.buildNotification(remoteMessage)
           }
        }
    }


}
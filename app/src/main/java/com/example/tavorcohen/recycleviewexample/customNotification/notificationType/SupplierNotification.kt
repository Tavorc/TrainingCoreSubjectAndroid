package com.example.tavorcohen.recycleviewexample.customNotification.notificationType

import android.content.Context
import android.net.Uri
import com.example.tavorcohen.recycleviewexample.R
import com.example.tavorcohen.recycleviewexample.customNotification.NotificationBuilder
import com.example.tavorcohen.recycleviewexample.customNotification.fcm.MyServiceFirebaseNotification.Companion.ALL_TYPES
import com.example.tavorcohen.recycleviewexample.customNotification.fcm.MyServiceFirebaseNotification.Companion.HANDIMAN
import com.google.firebase.messaging.RemoteMessage

class SupplierNotification(var category : String, var imageUrl : Uri, var mContext: Context?) : NotificationStrategy {
    private val id = 1
    override fun buildNotification(remoteMessage: RemoteMessage?) {
        when(category){
            ALL_TYPES -> {
                NotificationBuilder(mContext)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .build(id,remoteMessage,imageUrl)
                    .show()
            }

            HANDIMAN ->{
                NotificationBuilder(mContext)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .build(id,remoteMessage,imageUrl,category)
                    .show()
            }
        }
    }

}
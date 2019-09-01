package com.example.tavorcohen.recycleviewexample.customNotification.notificationType

import android.content.Context
import android.net.Uri
import com.example.tavorcohen.recycleviewexample.R
import com.example.tavorcohen.recycleviewexample.customNotification.NotificationBuilder
import com.google.firebase.messaging.RemoteMessage

class UserNotification(var imageUrl : Uri, var mContext: Context?) : NotificationStrategy {
    private val id = 2

    override fun buildNotification(remoteMessage: RemoteMessage?) {
        NotificationBuilder(mContext)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build(id,remoteMessage,imageUrl)
            .show()
    }
}
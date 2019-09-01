package com.example.tavorcohen.recycleviewexample.customNotification.notificationType

import com.google.firebase.messaging.RemoteMessage

interface NotificationStrategy {
    fun buildNotification(remoteMessage: RemoteMessage?)
}
package com.example.tavorcohen.recycleviewexample.customNotification.notificationService

import android.app.IntentService
import android.content.Context
import android.content.Intent
import com.example.tavorcohen.recycleviewexample.R
import com.example.tavorcohen.recycleviewexample.customNotification.NotificationBuilder


class ShowNotificationIntentService : IntentService("ShowNotificationIntentService") {

    private val STATUS_ICON_REQUEST_CODE =2

    companion object{
         val ACTION_SHOW_NOTIFICATION = "my.app.service.action.show"
         val ACTION_HIDE_NOTIFICATION = "my.app.service.action.hide"

        /**
         * show the notification in background
         */
        fun startActionShow(context: Context) {
            val intent = Intent(context, ShowNotificationIntentService::class.java)
            intent.action = ACTION_SHOW_NOTIFICATION
            context.startService(intent)
        }

        /**
         *  hide the notification
         */
        fun startActionHide(context: Context) {
            val intent = Intent(context, ShowNotificationIntentService::class.java)
            intent.action = ACTION_HIDE_NOTIFICATION
            context.startService(intent)
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        if (intent != null) {
            val action = intent.action
            if (ACTION_SHOW_NOTIFICATION == action) {
                handleActionShow()
            } else if (ACTION_HIDE_NOTIFICATION == action) {
                handleActionHide()
            }
        }
    }

    private fun handleActionShow() {
        showStatusBarIcon(this@ShowNotificationIntentService)
    }

    private fun handleActionHide() {
        hideStatusBarIcon(this@ShowNotificationIntentService)
    }

    /**
     * show the notification when the app in background mode
     */
    fun showStatusBarIcon(context: Context) {
        NotificationBuilder(context)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build(STATUS_ICON_REQUEST_CODE,"The app still running")
            .show(STATUS_ICON_REQUEST_CODE)
    }

    /**
     * hide the notification
     */
    fun hideStatusBarIcon(context: Context) {
        NotificationBuilder(context).deleteOneNotification(STATUS_ICON_REQUEST_CODE)
    }
}
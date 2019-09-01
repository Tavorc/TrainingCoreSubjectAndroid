package com.example.tavorcohen.recycleviewexample.customNotification.notificationService

import android.app.IntentService
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.Toast


/**
 * Creates an IntentService.  Invoked by your subclass's constructor.
 */
class NotificationIntentServiceAction : IntentService("notificationIntentService") {

    /**
     * handler when click on the button in the expanded notification
     */
    override fun onHandleIntent(intent: Intent?) {
        when (intent!!.action) {
            "click" -> {
                val clickHandler = Handler(Looper.getMainLooper())
                clickHandler.post(Runnable {
                    Toast.makeText(
                        baseContext,
                        "You clicked the left button",
                        Toast.LENGTH_LONG
                    ).show()
                })
            }
        }
    }
}
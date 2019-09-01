package com.example.tavorcohen.recycleviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tavorcohen.recycleviewexample.customNotification.notificationService.ShowNotificationIntentService

class CloseNotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_close_notification)
        ShowNotificationIntentService.startActionHide(applicationContext)
    }
}

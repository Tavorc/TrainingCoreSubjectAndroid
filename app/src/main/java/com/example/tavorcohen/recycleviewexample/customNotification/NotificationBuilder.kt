package com.example.tavorcohen.recycleviewexample.customNotification

import android.app.*
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.text.format.DateUtils
import android.widget.RemoteViews
import com.example.tavorcohen.recycleviewexample.CloseNotificationActivity
import com.example.tavorcohen.recycleviewexample.MainActivity
import com.example.tavorcohen.recycleviewexample.R
import com.example.tavorcohen.recycleviewexample.customNotification.notificationService.NotificationIntentServiceAction
import com.example.tavorcohen.recycleviewexample.utils.LayoutUtils
import com.google.firebase.messaging.RemoteMessage
import java.net.URL


class NotificationBuilder {
    private val NOTIFICATION_CHANNEL_ID = "Default Notifications"
    private val NOTIFICATION_CHANNEL_NAME = "Default Notifications"
    private val ID = "id"
    private var mSmallIcon: Int = 0
    private var mContext: Context? = null
    private var mNotification: Notification? = null

    constructor(mContext: Context?) {
        this.mContext = mContext
    }

    fun setSmallIcon(resId: Int): NotificationBuilder {
        this.mSmallIcon = resId
        return this
    }


    /**
     * Function that build the notification for specific type of supplier
     * @param id
     * @return
     */
    fun build(id: Int, remoteMessage: RemoteMessage?, uri: Uri, category : String): NotificationBuilder {
        val buildIntent = buildIntent(id)

        buildChannel(mContext?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)

        var urlImage= URL(uri.toString())
        val converUrlToBitmap = LayoutUtils.convertUrlToBitmap(urlImage)

        val notificationLayout = RemoteViews(mContext!!.packageName, R.layout.expanded_notification)
        notificationLayout.setTextViewText(R.id.content_title,"Hello " + category)
        notificationLayout.setTextViewText(R.id.content_text,remoteMessage?.data?.get("body"))
        notificationLayout.setImageViewBitmap(R.id.notification_img,converUrlToBitmap)

        val leftIntent = Intent(mContext, NotificationIntentServiceAction::class.java)
        leftIntent.action = "left"
        notificationLayout.setOnClickPendingIntent(R.id.left_button, PendingIntent.getService(mContext, 0, leftIntent, PendingIntent.FLAG_UPDATE_CURRENT))

        val collapsedView = RemoteViews(mContext!!.packageName, R.layout.collapsed_notification)
        collapsedView.setTextViewText(
            R.id.timestamp,
            DateUtils.formatDateTime(mContext, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME)
        )

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = mContext?.let {
            NotificationCompat.Builder(it, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(mSmallIcon)
                .setStyle(NotificationCompat.DecoratedCustomViewStyle())
                .setContent(notificationLayout)
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(notificationLayout)
                .setContentIntent(buildIntent)
                .setSound(defaultSoundUri)
                .setContentTitle("Hello " + category)
                .setContentText(remoteMessage?.getData()?.get("body"))
        }
        this.mNotification = notificationBuilder?.build()
        return this
    }


    /**
     * Function that build the notification
     * @param id
     * @return
     */
    fun build(id: Int, remoteMessage: RemoteMessage?, uri: Uri): NotificationBuilder {
        val buildIntent = buildIntent(id)
        buildChannel(mContext?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)

        var urlImage = URL(uri.toString())
        val converUrlToBitmap = LayoutUtils.convertUrlToBitmap(urlImage)

        val notificationLayout = RemoteViews(mContext!!.packageName, R.layout.expanded_notification)
        notificationLayout.setTextViewText(R.id.content_title,  remoteMessage?.data?.get("title"))
        notificationLayout.setTextViewText(R.id.content_text,remoteMessage?.data?.get("body"))
        notificationLayout.setImageViewBitmap(R.id.notification_img,converUrlToBitmap)

        val leftIntent = Intent(mContext, NotificationIntentServiceAction::class.java)
        leftIntent.action = "click"
        notificationLayout.setOnClickPendingIntent(R.id.left_button, PendingIntent.getService(mContext, 0, leftIntent, PendingIntent.FLAG_UPDATE_CURRENT))


        val collapsedView = RemoteViews(mContext!!.packageName, R.layout.collapsed_notification)
        collapsedView.setTextViewText(
            R.id.timestamp,
            DateUtils.formatDateTime(mContext, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME)
        )

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = mContext?.let {
            NotificationCompat.Builder(it, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(mSmallIcon)
                .setStyle(NotificationCompat.DecoratedCustomViewStyle())
                .setContent(notificationLayout)
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(notificationLayout)
                .setContentIntent(buildIntent)
                .setSound(defaultSoundUri)
                .setContentTitle(remoteMessage?.getData()?.get("title"))
                .setContentText(remoteMessage?.getData()?.get("body"))
        }
        this.mNotification = notificationBuilder?.build()
        return this
    }


    private fun buildIntent(id : Int) : PendingIntent{
        val intent = Intent(mContext, MainActivity::class.java)
        intent.putExtra(ID, id)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            TaskStackBuilder.create(mContext)
                .addNextIntentWithParentStack(intent)
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        } else {
            TODO("VERSION.SDK_INT < JELLY_BEAN")
        }
        return pendingIntent
    }

    /**
     * build notification for background service
     */
    fun build(id: Int,title : String): NotificationBuilder {
        val intent = Intent(mContext, CloseNotificationActivity::class.java)
        intent.putExtra(ID, id)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            TaskStackBuilder.create(mContext)
                .addNextIntentWithParentStack(intent)
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        } else {
            TODO("VERSION.SDK_INT < JELLY_BEAN")
        }

        buildChannel(mContext?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)

        val notificationBuilder = mContext?.let {
            NotificationCompat.Builder(it, NOTIFICATION_CHANNEL_ID)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setOngoing(true)
                .setContentIntent(pendingIntent)
        }
        this.mNotification = notificationBuilder?.build()
        return this
    }



    private fun buildChannel(manager: NotificationManager) {
        var importance = 0

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            importance = NotificationManager.IMPORTANCE_HIGH
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, importance
            )
            manager.createNotificationChannel(mChannel)
        }
    }


    fun show() {
        val notificationManager = mContext?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(System.currentTimeMillis().toInt(), mNotification)
    }

    /**
     * show by notification id
     */
    fun show(id : Int) {
        val notificationManager = mContext?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(id, mNotification)
    }

    /**
     * delete one notification by id
     */
    fun deleteOneNotification( idNotification: Int){
        val notificationManager =mContext?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(idNotification)
    }

    /**
     * delete all notifications
     */
    fun deleteAllNotification(){
        val notificationManager =mContext?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancelAll()
    }
}
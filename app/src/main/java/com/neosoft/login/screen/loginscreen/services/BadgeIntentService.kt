package com.neosoft.login.screen.loginscreen.services

import android.annotation.TargetApi
import android.app.IntentService
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import com.neosoft.login.screen.loginscreen.R

import me.leolin.shortcutbadger.ShortcutBadger

class BadgeIntentService:IntentService {

    var NOTIFICATION_CHANNEL = "me.leolin.shortcutbadger.example"

    private var notificationId = 0
    constructor():super("BadgeIntentService")

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
    }


    private lateinit var notificationManager:NotificationManager
    override fun onHandleIntent(intent: Intent?) {

        if (intent != null) {
            var badgeCount = intent.getIntExtra("badgeCount", 0)

            notificationManager.cancel(notificationId)
            notificationId++

            var builder = Notification.Builder(applicationContext)
                    .setContentTitle("")
                    .setContentText("")
                    .setSmallIcon(R.mipmap.ic_launcher)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                setupNotificationChannel()

                builder.setChannelId(NOTIFICATION_CHANNEL)
            }

            var notification = builder.build()
            ShortcutBadger.applyNotification(applicationContext, notification, badgeCount)
            notificationManager.notify(notificationId, notification)
        }
    }

    override fun onCreate() {
        super.onCreate()
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "service started", Toast.LENGTH_LONG).show()
        return super.onStartCommand(intent, flags, startId)
    }
    @TargetApi(Build.VERSION_CODES.O)
    private fun setupNotificationChannel() {
        var channel = NotificationChannel(NOTIFICATION_CHANNEL, "ShortcutBadger Sample",
                NotificationManager.IMPORTANCE_DEFAULT)

        notificationManager.createNotificationChannel(channel)
    }

    override fun onDestroy() {
        Toast.makeText(this, "service destroyed", Toast.LENGTH_LONG).show()
        super.onDestroy()
    }
}

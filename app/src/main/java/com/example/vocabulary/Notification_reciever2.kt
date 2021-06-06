package com.example.vocabulary

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color

class Notification_reciever2 : BroadcastReceiver(){
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"

    override fun onReceive(context: Context?, intent: Intent?) {
        val NotificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val repeating_intent = Intent(context, NotificationActivity::class.java)

        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(context,200,repeating_intent, PendingIntent.FLAG_UPDATE_CURRENT)



        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId, description,
                android.app.NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(context, channelId)
                .setContentText("You have words to remember")
                .setSmallIcon(R.drawable.ic_launcher_background)
                //.setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher_background))
                .setContentIntent(pendingIntent)
                .setAutoCancel(false)
        }


        NotificationManager.notify(200,builder.build())
    }
}
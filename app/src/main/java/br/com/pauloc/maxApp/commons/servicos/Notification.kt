package br.com.pauloc.maxApp.commons.servicos

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import br.com.pauloc.maxApp.R
import br.com.pauloc.maxApp.UI.SplashScreenActivity

/* Adaptado por Maurício Benigno -  Solução proposta por Kyle Jablonski
* Em: https://www.raywenderlich.com/1214490-android-notifications-tutorial-getting-started*/

class Notification{
    fun createChannel(context: Context, importance: Int, showBadge: Boolean, name: String, description: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "${context.packageName}-$name"
            val channel = NotificationChannel(channelId, name, importance)
            channel.description = description
            channel.setShowBadge(showBadge)
            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun createNotification(context: Context, title: String, message: String, autoCancel: Boolean){

        /* Criando canal de notificações*/
        this.createChannel(context, NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
            context.getString(R.string.app_name), "MaxAppChannel")
        /* Criando notificação*/
        val channelId = "${context.packageName}-${context.getString(R.string.app_name)}"
        val notificationBuilder = NotificationCompat.Builder(context, channelId).apply{
            setSmallIcon(R.drawable.maxima_logotipo)
            setContentTitle(title)
            setContentText(message)
            priority = NotificationCompat.PRIORITY_DEFAULT
            setAutoCancel(autoCancel)
            val intent = Intent(context, SplashScreenActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
            setContentIntent(pendingIntent)
        }
        val notificationManager = NotificationManagerCompat. from (context)
        notificationManager.notify ( 1001 , notificationBuilder.build ())
    }
}
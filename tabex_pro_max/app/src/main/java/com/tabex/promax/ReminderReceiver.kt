package com.tabex.promax

import android.content.*
import androidx.core.app.NotificationCompat
import android.app.NotificationManager

class ReminderReceiver: BroadcastReceiver() {
 override fun onReceive(context: Context, intent: Intent) {
  val n = NotificationCompat.Builder(context, "tabex")
   .setContentTitle("Tabex")
   .setContentText("Пора принять таблетку")
   .setSmallIcon(android.R.drawable.ic_dialog_info)
   .build()

  val m = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
  m.notify(1,n)
 }
}

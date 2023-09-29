package com.yugpatel.mad_practical_8_21012011111

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun setAlarm(militime:Long,action:String){
        val intentalarm=Intent(applicationContext,AlarmBroadcastReceiver::class.java)
        intentalarm.putExtra(AlarmBroadcastReceiver.ALARMKEY,action)
        val pendingintent=PendingIntent.getBroadcast(applicationContext,4345,intentalarm,PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)
        val manager=getSystemService(ALARM_SERVICE) as AlarmManager
        if(action==AlarmBroadcastReceiver.ALARMSTRAT){
            manager.setExact(AlarmManager.RTC_WAKEUP,militime,pendingintent)
        }
        else if(action==AlarmBroadcastReceiver.ALARMSTOP){
            manager.cancel(pendingintent)
            sendBroadcast(intentalarm)
        }

    }
}
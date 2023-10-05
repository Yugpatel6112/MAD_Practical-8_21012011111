package com.yugpatel.mad_practical_8_21012011111

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmBroadcastReceiver : BroadcastReceiver() {
    companion object {

        val ALARMKEY = "KEY"
        val ALARMSTRAT = "START"
        val ALARMSTOP = "STOP"
    }

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val DATA = intent.getStringExtra(ALARMKEY)
        val intentservice=Intent(context,AlarmService::class.java)
        if (DATA == ALARMSTRAT) {
            context.startService(intentservice)
        }
        else{
            context.stopService(intentservice)
        }
    }
}
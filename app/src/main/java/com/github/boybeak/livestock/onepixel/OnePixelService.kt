package com.github.boybeak.livestock.onepixel

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class OnePixelService : Service() {

    companion object {
        private val TAG = OnePixelService::class.java.simpleName
    }

    private val screenReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent ?: return
            when(intent.action) {
                Intent.ACTION_SCREEN_OFF -> {
                    OnePixelManager.onScreenOff(this@OnePixelService)
                }
                Intent.ACTION_SCREEN_ON -> {
                    OnePixelManager.onScreenOn()
                }
            }
            Log.v(TAG, "onReceive action=${intent.action}")
            Toast.makeText(context, intent.action, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        Log.v(TAG, "onCreate")
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_OFF)
            addAction(Intent.ACTION_SCREEN_ON)
        }
        registerReceiver(screenReceiver, filter)
    }

    override fun onDestroy() {
        unregisterReceiver(screenReceiver)
    }
}

package com.github.boybeak.livestock.onepixel

import android.content.Context
import android.content.Intent
import android.util.Log
import java.lang.ref.WeakReference

object OnePixelManager {

    private val TAG = OnePixelManager::class.java.simpleName

    private var activityRef: WeakReference<OnePixelActivity>? = null

    fun install(context: Context) {
        context.startService(Intent(context, OnePixelService::class.java))
    }

    fun onScreenOn() {
        Log.v(TAG, "onScreenOn")
        if (activityRef == null) {
            return
        }
        val activity = activityRef?.get() ?: return
        activity.finish()
        activityRef?.clear()
        activityRef = null
    }

    fun onScreenOff(context: Context) {
        if (isOnePixelWorking()) {
            return
        }
        context.startActivity(Intent(context, OnePixelActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        })
    }

    private fun isOnePixelWorking(): Boolean {
        return activityRef != null && activityRef!!.get() != null
    }

    fun onOnePixelWorked(activity: OnePixelActivity) {
        Log.v(TAG, "onOnePixelWorked")
        activityRef = WeakReference(activity)
    }

}
package com.github.boybeak.livestock.account_sync

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class SyncService : Service() {

    companion object {
        private val TAG = SyncService::class.java.simpleName
    }

    private val syncAdapter: SyncAdapter by lazy {
        SyncAdapter(this, true)
    }

    override fun onBind(intent: Intent): IBinder {
        return syncAdapter.syncAdapterBinder
    }

    override fun onCreate() {
        Log.v(TAG, "onCreate")

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.v(TAG, "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }
}

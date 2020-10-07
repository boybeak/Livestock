package com.github.boybeak.livestock.account_sync

import android.app.Service
import android.content.Intent
import android.os.IBinder

class AccountService : Service() {

    private val accountAuthenticator: AccountAuthenticator by lazy {
        AccountAuthenticator(this)
    }

    override fun onBind(intent: Intent): IBinder {
        return accountAuthenticator.iBinder
    }
}

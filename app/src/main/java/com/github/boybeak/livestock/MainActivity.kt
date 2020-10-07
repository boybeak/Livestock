package com.github.boybeak.livestock

import android.accounts.AccountManager
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.SyncRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.github.boybeak.livestock.account_sync.AccountAuthenticator
import com.github.boybeak.livestock.account_sync.SyncAdapter
import com.github.boybeak.livestock.onepixel.OnePixelActivity
import com.github.boybeak.livestock.onepixel.OnePixelManager

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun startOnePixel(v: View) {
        Toast.makeText(this, "startOnePixel", Toast.LENGTH_SHORT).show()
//        startActivity(Intent(this, OnePixelActivity::class.java))
        OnePixelManager.install(this)
    }

    fun startAccountSync(v: View) {
        val accountMan = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
        if (accountMan.accounts.isEmpty()) {
            Toast.makeText(this, "No accounts", Toast.LENGTH_SHORT).show()
            return
        }
        val authority = "com.android.contacts"
        val account = accountMan.accounts[0]
        ContentResolver.setSyncAutomatically(account, authority, true)
        ContentResolver.addPeriodicSync(account, authority, Bundle.EMPTY, 60)
        ContentResolver.setIsSyncable(account, authority, 1)
        Toast.makeText(this, "Started ${ContentResolver.isSyncActive(account, authority)}", Toast.LENGTH_SHORT).show()
    }

    fun doSyncAccount(v: View) {

        val man = AccountManager.get(this)
        val account = man.accounts[0]

        val authority = "com.android.contacts"

        ContentResolver.requestSync(
            SyncRequest.Builder()
                .syncOnce()
                .setExtras(Bundle())
                .setSyncAdapter(account, authority)
                .build()
        )
    }

}
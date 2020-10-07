package com.github.boybeak.livestock.account_sync

import android.accounts.Account
import android.accounts.AccountAuthenticatorActivity
import android.accounts.AccountManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.boybeak.livestock.R

class AccountCreateActivity : AccountAuthenticatorActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_create)

        val account = Account("A-FEI", AccountAuthenticator.ACCOUNT_TYPE)
        val accountMan = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager

        accountMan.addAccountExplicitly(account, "12345", Bundle())
    }

}
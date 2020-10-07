package com.github.boybeak.livestock.account_sync

import android.accounts.AbstractAccountAuthenticator
import android.accounts.Account
import android.accounts.AccountAuthenticatorResponse
import android.accounts.AccountManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log

class AccountAuthenticator(val context: Context) : AbstractAccountAuthenticator(context) {

    companion object {
        private val TAG = AccountAuthenticator::class.java.simpleName

        const val ACCOUNT_TYPE = "com.github.boybeak.livestock.auth"
    }

    override fun editProperties(
        response: AccountAuthenticatorResponse?,
        accountType: String?
    ): Bundle {
        Log.v(TAG, "editProperties")
        return Bundle().apply {
            putParcelable("response", response)
            putString("accountType", accountType)
        }
    }

    override fun addAccount(
        response: AccountAuthenticatorResponse?,
        accountType: String?,
        authTokenType: String?,
        requiredFeatures: Array<out String>?,
        options: Bundle?
    ): Bundle {
        Log.v(TAG, "addAccount")
        val intent = Intent(context, AccountCreateActivity::class.java).apply {
            putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response)
        }
        return Bundle().apply {
            putParcelable(AccountManager.KEY_INTENT, intent)
        }
    }

    override fun confirmCredentials(
        response: AccountAuthenticatorResponse?,
        account: Account?,
        options: Bundle?
    ): Bundle {
        Log.v(TAG, "confirmCredentials")
        return Bundle().apply {
            putParcelable("response", response)
            putParcelable("account", account)
        }
    }

    override fun getAuthToken(
        response: AccountAuthenticatorResponse?,
        account: Account?,
        authTokenType: String?,
        options: Bundle?
    ): Bundle {
        Log.v(TAG, "getAuthToken")
        return Bundle().apply {
            putParcelable("response", response)
            putParcelable("account", account)
        }
    }

    override fun getAuthTokenLabel(authTokenType: String?): String {
        Log.v(TAG, "getAuthTokenLabel")
        return ""
    }

    override fun updateCredentials(
        response: AccountAuthenticatorResponse?,
        account: Account?,
        authTokenType: String?,
        options: Bundle?
    ): Bundle {
        Log.v(TAG, "updateCredentials")
        return Bundle().apply {
            putParcelable("response", response)
            putParcelable("account", account)
        }
    }

    override fun hasFeatures(
        response: AccountAuthenticatorResponse?,
        account: Account?,
        features: Array<out String>?
    ): Bundle {
        Log.v(TAG, "hasFeatures")
        return Bundle().apply {
            putParcelable("response", response)
            putParcelable("account", account)
        }
    }
}
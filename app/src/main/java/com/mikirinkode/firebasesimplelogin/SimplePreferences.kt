package com.mikirinkode.firebasesimplelogin

import android.content.Context
import android.content.SharedPreferences

class SimplePreferences(context: Context)  {


    private var sharedPreferences: SharedPreferences = context.getSharedPreferences(USER_PREF, 0)

    fun setValues(key: String, value: String?) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getValues(key: String): String? {
        return sharedPreferences.getString(key, "")
    }


    companion object {

        const val LOGIN_STATUS = "login_status"
        const val LOGGED_IN = "1"
        const val LOGGED_OUT = "0"

        const val USER_EMAIL = "user_email"
        const val USER_ID = "user_id"

        private const val USER_PREF: String = "user_pref"
    }
}
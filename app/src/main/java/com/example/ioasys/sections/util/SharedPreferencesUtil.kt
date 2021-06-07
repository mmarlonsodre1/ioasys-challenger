package com.example.ioasys.sections.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

const val PREF_NAME = "com.example.ioasys"
inline val Context.sharedPreferences: SharedPreferences
    get() = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

fun Context.saveString(key: String, value: String) {
    val sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    sp.edit().apply {
        putString(key, value)
        apply()
    }
}

fun Context.getStringPreferences(key: String): String {
    val sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    return sp.getString(key, "") ?: ""
}
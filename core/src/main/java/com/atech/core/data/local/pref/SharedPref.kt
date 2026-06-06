package com.atech.core.data.local.pref

import android.content.SharedPreferences
import javax.inject.Inject
import androidx.core.content.edit


const val PREF_NAME = "CurrentsAppPref"

/**
 * A sealed class representing the keys used for storing preferences in SharedPreferences.
 *
 * @param T The type of the preference value.
 * @property key The key used to identify the preference in SharedPreferences.
 * @property defaultValue The default value for the preference if it is not set.
 */
sealed class PrefKey<T>(
    val key: String,
    val defaultValue: T
) {

    data object IsLoggedIn : PrefKey<Boolean>(
        key = "is_logged_in",
        defaultValue = false
    )
    data object IsLogInSkipped : PrefKey<Boolean>(
        key = "is_login_skipped",
        defaultValue = false
    )
}

class PrefManager @Inject constructor(
    private val sharedPreferences: SharedPreferences
){
    fun <T> put(key: PrefKey<T>, value: T) {
        sharedPreferences.edit {
            when (value) {
                is String -> putString(key.key, value)
                is Int -> putInt(key.key, value)
                is Boolean -> putBoolean(key.key, value)
                is Float -> putFloat(key.key, value)
                is Long -> putLong(key.key, value)
                else -> error("Unsupported type")
            }
        }
    }
    @Suppress("UNCHECKED_CAST")
    fun <T> get(key: PrefKey<T>): T {
        return when (key.defaultValue) {
            is String -> sharedPreferences.getString(
                key.key,
                key.defaultValue
            ) as T

            is Int -> sharedPreferences.getInt(
                key.key,
                key.defaultValue
            ) as T

            is Boolean -> sharedPreferences.getBoolean(
                key.key,
                key.defaultValue
            ) as T

            is Float -> sharedPreferences.getFloat(
                key.key,
                key.defaultValue
            ) as T

            is Long -> sharedPreferences.getLong(
                key.key,
                key.defaultValue
            ) as T

            else -> error("Unsupported type")
        }
    }
}


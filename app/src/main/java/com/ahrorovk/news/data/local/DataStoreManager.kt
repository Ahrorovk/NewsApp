package com.ahrorovk.news.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class DataStoreManager(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("preferences_name")
        val NOTIFICATIONS_REPETITIONS_KEY = intPreferencesKey("notifications_repetitions")
        val START_AT_NOTIFICATION_KEY = intPreferencesKey("start_at_notification")
        val END_AT_NOTIFICATION_KEY = intPreferencesKey("end_at_notification")
        val LANGUAGE_SHORTCUT_KEY = stringPreferencesKey("LANGUAGE_SHORTCUT_KEY")
        val DARK_THEME_KEY = booleanPreferencesKey("DARK_THEME_KEY")
        val THE_FIRST_LOCALE_LANGUAGE_KEY = intPreferencesKey("THE_FIRST_LOCALE_LANGUAGE_KEY")
        val IS_NOTIFICATION_ON_KEY = booleanPreferencesKey("IS_NOTIFICATION_ON_KEY")
        val COINS = longPreferencesKey("COINS")
    }

    suspend fun updateNotificationsRepetition(times: Int) {
        context.dataStore.edit { preferences ->
            preferences[NOTIFICATIONS_REPETITIONS_KEY] = times
        }
    }

    suspend fun updateDarkThemeState(state: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[DARK_THEME_KEY] = state
        }
    }

    suspend fun updateStartAtNotification(date: Int) {
        context.dataStore.edit { preferences ->
            preferences[START_AT_NOTIFICATION_KEY] = date
        }
    }

    suspend fun updateEndAtNotification(date: Int) {
        context.dataStore.edit { preferences ->
            preferences[END_AT_NOTIFICATION_KEY] = date
        }
    }

    suspend fun updateLanguage(id: String) {
        context.dataStore.edit { preferences ->
            preferences[LANGUAGE_SHORTCUT_KEY] = id
        }
    }
    suspend fun updateLanguageState(id: Int) {
        context.dataStore.edit { preferences ->
            preferences[THE_FIRST_LOCALE_LANGUAGE_KEY] = id
        }
    }

    suspend fun updateIsNotificationOn(value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_NOTIFICATION_ON_KEY] = value
        }
    }

    suspend fun updateCoins(coin: Long) {
        context.dataStore.edit { preferences ->
            preferences[COINS] = coin
        }
    }

    val getCoins = context.dataStore.data.map {
        it[COINS] ?: 5
    }
    val getNotificationRepetition = context.dataStore.data.map {
        it[NOTIFICATIONS_REPETITIONS_KEY] ?: 5
    }
    val getStartAtNotification = context.dataStore.data.map {
        it[START_AT_NOTIFICATION_KEY] ?: 10
    }
    val getEndAtNotification = context.dataStore.data.map {
        it[END_AT_NOTIFICATION_KEY] ?: 20
    }
    val getLanguageId = context.dataStore.data.map {
        it[LANGUAGE_SHORTCUT_KEY] ?: "en"
    }
    val getDarkThemeState = context.dataStore.data.map {
        it[DARK_THEME_KEY] ?: false
    }
    val getLanguageState = context.dataStore.data.map {
        it[THE_FIRST_LOCALE_LANGUAGE_KEY] ?: 0
    }
    val getIsNotificationOn = context.dataStore.data.map {
        it[IS_NOTIFICATION_ON_KEY] ?: false
    }
}
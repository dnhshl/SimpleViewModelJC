package com.example.simpleviewmodel.model

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val Context.dataStore by preferencesDataStore(name = "settings")

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val dataStore = application.dataStore

    // clickCounter via Datastore
    private val clickCounterKey = intPreferencesKey("click_counter_key")

    // clickCounter aus dem Datastore abrufen (automatisch als Flow)
    val clickCounter = dataStore.data
        .map { preferences ->
            preferences[clickCounterKey] ?: 0
        }

    // clickCounter um eins erhöhen und abspeichern
    fun incrementAndSaveClickCounter() {
        viewModelScope.launch {
            dataStore.edit { preferences ->
                val currentValue = preferences[clickCounterKey] ?: 0
                preferences[clickCounterKey] = currentValue + 1
            }
        }
    }
}
package com.rl.rickandmortyapp.screens.locations

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.rl.rickandmortyapp.database.DatabaseRoom
import com.rl.rickandmortyapp.repository.LocationRepository
import kotlinx.coroutines.launch

class LocationViewModel(application: Application) : AndroidViewModel(application) {
    private val database = DatabaseRoom.getInstance(application.applicationContext)
    private val locationRepository = LocationRepository(database)

    val locations = locationRepository.locations


    /**
     * On initialization of the viewmodel we want to refresh the locations
     */
    init {
        viewModelScope.launch {
            locationRepository.refreshLocations()
        }
    }
}
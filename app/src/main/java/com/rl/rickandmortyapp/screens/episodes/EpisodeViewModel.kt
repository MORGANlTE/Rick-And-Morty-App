package com.rl.rickandmortyapp.screens.episodes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.rl.rickandmortyapp.database.DatabaseRoom
import com.rl.rickandmortyapp.repository.EpisodeRepository
import kotlinx.coroutines.launch

class EpisodeViewModel(application: Application) : AndroidViewModel(application) {
    private val database = DatabaseRoom.getInstance(application.applicationContext)
    private val episodeRepository = EpisodeRepository(database)

    val episodes = episodeRepository.episodes

    /**
     * On initialization of the viewmodel we want to refresh the episodes
     */
    init {
        viewModelScope.launch {
            episodeRepository.refreshEpisodes()
        }
    }
}
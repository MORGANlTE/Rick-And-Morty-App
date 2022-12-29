package com.rl.rickandmortyapp.screens.episodes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EpisodesViewModel : ViewModel() {
    // The current word
    val episodes = MutableLiveData<List<Episode>>()
    // The current score
    init {
        Log.i("EpisodesViewModel", "EpisodesViewModel created!")
        episodes.value = listOf(
            Episode(1, "test", "1", "today"),
            Episode(2, "test2", "2", "today")
        )
    }
}
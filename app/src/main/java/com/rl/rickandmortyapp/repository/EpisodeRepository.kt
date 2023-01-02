package com.rl.rickandmortyapp.repository

import android.util.Log
import androidx.lifecycle.Transformations
import com.rl.rickandmortyapp.database.DatabaseRoom
import com.rl.rickandmortyapp.database.episode.asDomain
import com.rl.rickandmortyapp.network.episodes.EpisodeApi
import com.rl.rickandmortyapp.network.episodes.asDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EpisodeRepository(private val db: DatabaseRoom) {
    //get episodes from db and map them to domain objects
    val episodes = Transformations.map(db.episodeDao.getAllEpisodes()) {
        it.asDomain()
    }
    /**
     * Refreshes the current episodes & inserts them into the database
     */
    suspend fun refreshEpisodes() {
        withContext(Dispatchers.IO) {
            try {
                //get characters from api
                val res = EpisodeApi.retrofitService.getEpisodes().await()
                val episodes = res.results
                //insert into db
                db.episodeDao.insertAll(episodes.asDatabase())
            } catch (e: Exception) {
                Log.e("error", e.message.toString())
            }
        }
    }
}
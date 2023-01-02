package com.rl.rickandmortyapp.database.episode

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
/**
 * DAO for the episodes
 */
@Dao
interface EpisodeDao {
    /**
     * Inserts the episodes from the api
     * @param episodes The episodes to insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(episodes:Array<Episode>)

    /**
     * Gets all the episodes from the api
     */
    @Query("SELECT * FROM episode_table ORDER BY episodeId ASC")
    fun getAllEpisodes(): LiveData<List<Episode>>
}
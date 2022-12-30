package com.rl.rickandmortyapp.database.episode

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EpisodeDao {
    //to insert the episodes from the api
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(episodes:Array<Episode>)

    //get all of the episodes into the db
    @Query("SELECT * FROM episode_table ORDER BY episodeId ASC")
    fun getAllEpisodes(): LiveData<List<Episode>>
}
package com.rl.rickandmortyapp.database.location

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LocationDao {
    /**
     * Inserts the locations from the api
     * @param locations The locations to insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(locations:Array<Location>)

    /**
     * Gets all the locations from the api
     */
    @Query("SELECT * FROM location_table ORDER BY locationId ASC")
    fun getAllLocations(): LiveData<List<Location>>
}
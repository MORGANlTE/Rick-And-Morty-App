package com.rl.rickandmortyapp.database.location

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LocationDao {
    //to insert the locations from the api
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(locations:Array<Location>)

    //get all of the locations into the db
    @Query("SELECT * FROM location_table ORDER BY locationId ASC")
    fun getAllLocations(): LiveData<List<Location>>
}
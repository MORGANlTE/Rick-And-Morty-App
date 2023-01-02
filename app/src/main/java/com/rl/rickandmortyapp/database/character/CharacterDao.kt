package com.rl.rickandmortyapp.database.character

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
/**
 * DAO for the characters
 */
@Dao
interface CharacterDao {
    /**
     * Inserts the characters from the api
     * @param characters The characters to insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: Array<Character>)

    /**
     * Gets all the characters from the api
     */
    @Query("SELECT * FROM character_table ORDER BY characterId ASC")
    fun getAllCharacters(): LiveData<List<Character>>

}
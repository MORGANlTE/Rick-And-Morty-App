package com.rl.rickandmortyapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CharacterDatabaseDao {
    //to insert characters from api
    @Insert
    suspend fun insert(character: Character)

    //to update this db with up-to-date values from api
    @Update
    suspend fun update(character: Character)

    //get all of the characters in the db
    @Query("SELECT * FROM character_table ORDER BY characterId DESC")
    fun getAllCharacters(): LiveData<List<Character>>

}
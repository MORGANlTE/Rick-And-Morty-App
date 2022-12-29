package com.rl.rickandmortyapp.database.character

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDao {
    //to insert characters from api
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: Character)

    //get all of the characters in the db
    @Query("SELECT * FROM character_table ORDER BY characterId ASC")
    fun getAllCharacters(): LiveData<List<Character>>

}
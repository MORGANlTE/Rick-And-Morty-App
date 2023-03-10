package com.rl.rickandmortyapp.repository

import android.util.Log
import androidx.lifecycle.Transformations
import com.rl.rickandmortyapp.database.DatabaseRoom
import com.rl.rickandmortyapp.database.character.asDomain
import com.rl.rickandmortyapp.network.character.CharacterApi
import com.rl.rickandmortyapp.network.character.asDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterRepository(private val db: DatabaseRoom) {
    /**
     * Gets characters from db and maps them to domain objects
     */
    val characters = Transformations.map(db.characterDao.getAllCharacters()) {
        it.asDomain()
    }
    /**
     * Refreshes the current characters & inserts them into the local database
     */
    suspend fun refreshCharacters() {
        withContext(Dispatchers.IO) {
            try {
                //get characters from api
                val res = CharacterApi.retrofitService.getCharacters().await()
                val characters = res.results
                //insert into db
                db.characterDao.insertAll(characters.asDatabase())
            } catch (e: Exception) {
                Log.e("hier", e.message.toString())
            }
        }
    }
}

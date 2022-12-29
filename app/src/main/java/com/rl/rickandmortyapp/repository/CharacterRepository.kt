package com.rl.rickandmortyapp.repository

import androidx.lifecycle.Transformations
import com.rl.rickandmortyapp.database.DatabaseRoom
import com.rl.rickandmortyapp.database.character.asDomain

class CharacterRepository(private val db: DatabaseRoom) {
    //get characters from db and map them to domain objects
    val characters = Transformations.map(db.characterDao.getAllCharacters()) {
        it.asDomain()
    }
}
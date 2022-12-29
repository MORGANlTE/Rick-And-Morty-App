package com.rl.rickandmortyapp.screens.character

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rl.rickandmortyapp.database.DatabaseRoom
import com.rl.rickandmortyapp.database.character.Character
import com.rl.rickandmortyapp.database.character.CharacterDao
import com.rl.rickandmortyapp.repository.CharacterRepository
import kotlinx.coroutines.launch

class CharacterViewModel(application: Application) : AndroidViewModel(application) {

    private val database = DatabaseRoom.getInstance(application.applicationContext)
    private val characterRepository = CharacterRepository(database)

    val characters = characterRepository.characters

    init {
        //insert 2 characters into the db
        viewModelScope.launch {
            characterRepository.refreshCharacters()
//            insert(
//                Character(
//                    1L, "de rick", "alive",
//                    "human", "imgurl", "earth"
//                )
//            )
//            insert(
//                Character(
//                    2L, "de rick2", "alive2",
//                    "human2", "imgurl2", "earth2"
//                )
//            )
        }
    }

}
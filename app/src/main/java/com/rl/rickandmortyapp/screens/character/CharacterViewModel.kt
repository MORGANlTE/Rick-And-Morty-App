package com.rl.rickandmortyapp.screens.character

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rl.rickandmortyapp.database.character.Character
import com.rl.rickandmortyapp.database.character.CharacterDao
import kotlinx.coroutines.launch

class CharacterViewModel(dataSource: CharacterDao, application: Application) : ViewModel() {

    val database = dataSource
    val characters = database.getAllCharacters()

    init {
        //insert 2 characters into the db
        viewModelScope.launch {
            insert(
                Character(
                    1L, "de rick", "alive",
                    "human", "imgurl", "earth"
                )
            )
            insert(
                Character(
                    2L, "de rick2", "alive2",
                    "human2", "imgurl2", "earth2"
                )
            )
        }
    }

    private suspend fun insert(character: Character) {
        database.insert(character)
    }


    fun logIets() {
        Log.i("hier", "iets haha")
    }

}
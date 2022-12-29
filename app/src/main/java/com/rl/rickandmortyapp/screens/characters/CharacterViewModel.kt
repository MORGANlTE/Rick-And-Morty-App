package com.rl.rickandmortyapp.screens.characters

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rl.rickandmortyapp.database.Character
import com.rl.rickandmortyapp.database.CharacterDatabaseDao
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class CharacterViewModel(dataSource: CharacterDatabaseDao, application: Application) : ViewModel() {

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
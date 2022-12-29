package com.rl.rickandmortyapp.screens.characters

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rl.rickandmortyapp.database.Character
import com.rl.rickandmortyapp.database.CharacterDatabaseDao

class CharacterViewModel(dataSource: CharacterDatabaseDao, application: Application) : ViewModel() {

//    val characters = dataSource.getAllCharacters()

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>>
        get() = _characters

    init {
        _characters.value = listOf(
            Character(
                0L, "de rick", "alive",
                "human", "imgurl", "earth"
            ),
            Character(
                1L, "de rick2", "alive2",
                "human2", "imgurl2", "earth2"
            )
        )
    }


    fun logIets() {
        Log.i("hier", "iets haha")
    }

}
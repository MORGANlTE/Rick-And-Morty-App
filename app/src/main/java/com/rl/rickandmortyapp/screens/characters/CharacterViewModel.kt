package com.rl.rickandmortyapp.screens.characters

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import com.rl.rickandmortyapp.database.CharacterDatabaseDao

class CharacterViewModel(dataSource: CharacterDatabaseDao, application: Application) : ViewModel() {

    fun logIets() {
        Log.i("hier", "iets haha")
    }

}
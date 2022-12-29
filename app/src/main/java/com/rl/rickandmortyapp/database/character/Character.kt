package com.rl.rickandmortyapp.database.character

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rl.rickandmortyapp.database.character.Character

@Entity(tableName = "character_table")
data class Character(
    @PrimaryKey(autoGenerate = true)
    var characterId: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "species")
    var species: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "origin")
    var origin: String, //origin.name, bv 'Earth (C-500A)'
)

//convert a list of DB objects to a list of Domain objects
fun List<Character>.asDomain(): List<com.rl.rickandmortyapp.domain.Character> {
    return map {
        com.rl.rickandmortyapp.domain.Character(
            characterId = it.characterId,
            name = it.name,
            status = it.status,
            species = it.species,
            image = it.image,
            origin = it.origin
        )
    }
}
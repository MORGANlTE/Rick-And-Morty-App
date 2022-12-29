package com.rl.rickandmortyapp.network.character

import com.squareup.moshi.Json

data class CharacterResponse (
    @Json(name = "results")
    val results: List<CharacterDto>
)

data class CharacterDto (
    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "status")
    val status: String,

    @Json(name = "species")
    val species: String,

    @Json(name = "image")
    val image: String,

    @Json(name = "origin")
    val origin: CharacterOriginDto
)

data class CharacterOriginDto (
    @Json(name = "name")
    val originName: String
)

fun List<CharacterDto>.asDatabase(): Array<com.rl.rickandmortyapp.database.character.Character> {
    return this.map {
        com.rl.rickandmortyapp.database.character.Character(
            characterId = it.id.toLong(),
            name = it.name,
            status = it.status,
            species = it.species,
            image = it.image,
            origin = it.origin.originName
        )
    }.toTypedArray()
}
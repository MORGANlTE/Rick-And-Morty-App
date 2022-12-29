package com.rl.rickandmortyapp.domain

data class Character (
    val characterId: Long,
    val name: String,
    val status: String,
    val species: String,
    val image: String,
    val origin: String
)
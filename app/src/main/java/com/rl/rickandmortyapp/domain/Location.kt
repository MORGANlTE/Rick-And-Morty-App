package com.rl.rickandmortyapp.domain

data class Location (
    val locationId: Long,
    val name: String,
    val type: String,
    val dimension: String,
)
package com.rl.rickandmortyapp.network.location

import com.squareup.moshi.Json

data class LocationResponse (
    @Json(name = "results")
    val results: List<LocationDto>
)

data class LocationDto (
    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "type")
    val type: String,

    @Json(name = "dimension")
    val dimension: String,
)

fun List<LocationDto>.asDatabase(): Array<com.rl.rickandmortyapp.database.location.Location> {
    return this.map {
        com.rl.rickandmortyapp.database.location.Location(
            locationId = it.id.toLong(),
            name = it.name,
            type = it.type,
            dimension = it.dimension,
        )
    }.toTypedArray()
}
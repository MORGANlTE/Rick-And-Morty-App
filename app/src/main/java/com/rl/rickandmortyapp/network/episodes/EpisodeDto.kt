package com.rl.rickandmortyapp.network.episodes

import com.squareup.moshi.Json

data class EpisodeResponse (
    @Json(name = "results")
    val results: List<EpisodeDto>
)

data class EpisodeDto (
    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "episode")
    val episode: String,
)

fun List<EpisodeDto>.asDatabase(): Array<com.rl.rickandmortyapp.database.episode.Episode> {
    return this.map {
        com.rl.rickandmortyapp.database.episode.Episode(
            episodeId = it.id.toLong(),
            name = it.name,
            episode = it.episode,
        )
    }.toTypedArray()
}
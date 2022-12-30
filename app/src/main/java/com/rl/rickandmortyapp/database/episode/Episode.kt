package com.rl.rickandmortyapp.database.episode

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "episode_table")
data class Episode(
    @PrimaryKey(autoGenerate = true)
    var episodeId: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "episode")
    var episode:  String,
)

//convert a list of DB objects to a list of Domain objects
fun List<Episode>.asDomain(): List<com.rl.rickandmortyapp.domain.Episode> {
    return map {
        com.rl.rickandmortyapp.domain.Episode(
            episodeId = it.episodeId,
            name = it.name,
            episode = it.episode,
        )
    }
}

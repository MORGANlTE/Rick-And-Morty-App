package com.rl.rickandmortyapp.database.location


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "location_table")
data class Location(
    @PrimaryKey(autoGenerate = true)
    var locationId: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "dimension")
    var dimension: String,
)

/**
 * convert a list of DB objects to a list of Domain objects
 */
fun List<Location>.asDomain(): List<com.rl.rickandmortyapp.domain.Location> {
    return map {
        com.rl.rickandmortyapp.domain.Location(
            locationId = it.locationId,
            name = it.name,
            type = it.type,
            dimension = it.dimension,
        )
    }
}

package com.rl.rickandmortyapp.repository

import android.util.Log
import androidx.lifecycle.Transformations
import com.rl.rickandmortyapp.database.DatabaseRoom
import com.rl.rickandmortyapp.database.location.asDomain
import com.rl.rickandmortyapp.network.location.LocationApi
import com.rl.rickandmortyapp.network.location.asDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocationRepository(private val db: DatabaseRoom) {
    //get locations from db and map them to domain objects
    val locations = Transformations.map(db.locationDao.getAllLocations()) {
        it.asDomain()
    }

    suspend fun refreshCharacters() {
        withContext(Dispatchers.IO) {
            try {
                //get characters from api
                val res = LocationApi.retrofitService.getLocations().await()
                val locations = res.results
                //insert into db
                db.locationDao.insertAll(locations.asDatabase())
            } catch (e: Exception) {
                Log.e("error", e.message.toString())
            }
        }
    }
}
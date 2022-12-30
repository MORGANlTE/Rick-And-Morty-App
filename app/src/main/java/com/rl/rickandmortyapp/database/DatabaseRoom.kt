package com.rl.rickandmortyapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rl.rickandmortyapp.database.character.Character
import com.rl.rickandmortyapp.database.character.CharacterDao
import com.rl.rickandmortyapp.database.location.Location
import com.rl.rickandmortyapp.database.location.LocationDao

@Database(entities = [Character::class, Location::class], version = 2, exportSchema = false)
abstract class DatabaseRoom : RoomDatabase() {

    //connect DB with Dao
    abstract val characterDao: CharacterDao
    abstract val locationDao: LocationDao

    // companion object to add functions to the class (the class itself, not an instance of the class)
    companion object {
        // reference to any db returned via getInstance
        // -> avoid to repeatedly initialize the db
        // volatile: value will never be cached, all reads & writes are done from the main memory
        // -> changes made by one thread are visible to other threads
        @Volatile
        private var INSTANCE: DatabaseRoom? = null

        fun getInstance(context: Context): DatabaseRoom {
            // Multiple threads can ask for the database at the same time, ensure we only initialize
            // it once by using synchronized. Only one thread may enter a synchronized block at a
            // time.
            synchronized(this) {
                //get current value
                var instance = INSTANCE

                //if it's empty, create a new database instance
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseRoom::class.java,
                        "character_database",
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }

                //return the instance
                return instance
            }
        }
    }

}
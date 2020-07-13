package pe.devpicon.android.myweatherapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(City::class), version = 1, exportSchema = false)
abstract class WeatherRoomDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    companion object {
        @Volatile
        private var INSTANCE: WeatherRoomDatabase? = null

        fun getDatabase(context: Context): WeatherRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context,
                        WeatherRoomDatabase::class.java,
                        "weather_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

package pe.devpicon.android.myweatherapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(city: City)

    @Query("SELECT * from city_table ORDER BY name ASC")
    fun getStoredCities(): List<City>

    @Query("SELECT EXISTS(SELECT * FROM city_table WHERE woeid = :id)")
    fun isCityExist(id: Long): Boolean
}
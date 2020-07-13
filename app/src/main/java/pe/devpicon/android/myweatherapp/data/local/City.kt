package pe.devpicon.android.myweatherapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_table")
data class City(
        @PrimaryKey @ColumnInfo(name = "woeid") val id: Long,
        @ColumnInfo(name = "name") val name: String
)
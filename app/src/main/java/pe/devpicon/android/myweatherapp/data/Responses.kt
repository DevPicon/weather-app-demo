package pe.devpicon.android.myweatherapp.data

import com.squareup.moshi.Json

class SearchResult(
        @Json(name = "title") val title: String,
        @Json(name = "location_type") val locationType: String,
        @Json(name = "woeid") val weatherId: Long,
        @Json(name = "location_type") val coordinates: String
)

class ConsolidatedWeather(
        @Json(name = "consolidated_weather") val consolidatedWeather: List<Weather>
)

class Weather(
        @Json(name = "id") val id: Long,
        @Json(name = "weather_state_name") val weatherStateName: String,
        @Json(name = "weather_state_abbr") val weatherStateAbbr: String,
        @Json(name = "applicable_date") val applicableDate: String,
        @Json(name = "the_temp") val currentTemperature: Int,
        @Json(name = "min_temp") val minTemperature: Double,
        @Json(name = "max_temp") val maxTemperature: Double
)
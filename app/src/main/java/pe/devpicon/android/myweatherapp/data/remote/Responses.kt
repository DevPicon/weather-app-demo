package pe.devpicon.android.myweatherapp.data.remote

import com.google.gson.annotations.SerializedName

class SearchResults(
        val resultResponses: List<SearchResultResponse>
)

class SearchResultResponse(
        @SerializedName(value = "title") val title: String,
        @SerializedName(value = "location_type") val locationType: String,
        @SerializedName(value = "woeid") val weatherId: Long,
        @SerializedName(value = "latt_long") val coordinates: String
)

class ConsolidatedWeatherResponse(
        @SerializedName(value = "title") val title:String,
        @SerializedName(value = "consolidated_weather") val consolidatedWeatherResponse: List<WeatherResponse>
)

class WeatherResponse(
        @SerializedName(value = "id") val id: Long,
        @SerializedName(value = "weather_state_name") val weatherStateName: String,
        @SerializedName(value = "weather_state_abbr") val weatherStateAbbr: String,
        @SerializedName(value = "applicable_date") val applicableDate: String,
        @SerializedName(value = "the_temp") val currentTemperature: Int,
        @SerializedName(value = "min_temp") val minTemperature: Double,
        @SerializedName(value = "max_temp") val maxTemperature: Double
)
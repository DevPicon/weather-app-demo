package pe.devpicon.android.myweatherapp.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {
    @GET("location/search/")
    suspend fun search(
            @Query("query") searchText: String
    ): List<SearchResultResponse>


    @GET("location/{woeid}/")
    suspend fun fetchWeatherById(
            @Path("woeid") whereOnTheEarthid: Long
    ): ConsolidatedWeatherResponse
}
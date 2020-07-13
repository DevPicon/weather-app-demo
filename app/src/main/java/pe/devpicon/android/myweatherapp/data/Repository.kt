package pe.devpicon.android.myweatherapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.devpicon.android.myweatherapp.data.local.City

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

class WeatherRepository() {

    suspend fun search(searchText: String): List<SearchResultResponse> {
        return service.search(searchText)
    }

    suspend fun fetchWeatherById(woeId: Long): ConsolidatedWeatherResponse {
        return service.fetchWeatherById(woeId)
    }

}

class WeatherLocalRepository() {
    suspend fun getStoredCityList(): List<City> = withContext(Dispatchers.IO) {
        listOf(City(1L, "Lima"),
                City(2L, "Santiago"))
    }
}
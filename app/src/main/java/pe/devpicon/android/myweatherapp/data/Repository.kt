package pe.devpicon.android.myweatherapp.data

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

class WeatherRepository() {

    suspend fun search(searchText: String): List<SearchResultResponse> {
        return service.search(searchText)
    }

    suspend fun fetchWeatherById(woeId:Long):ConsolidatedWeatherResponse{
        return service.fetchWeatherById(woeId)
    }

}

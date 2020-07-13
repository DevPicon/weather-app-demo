package pe.devpicon.android.myweatherapp.data.remote

class WeatherRemoteDatasource(private val weatherService: WeatherService) {

    suspend fun search(searchText: String): List<SearchResultResponse> {
        return weatherService.search(searchText)
    }

    suspend fun fetchWeatherById(woeId: Long): ConsolidatedWeatherResponse {
        return weatherService.fetchWeatherById(woeId)
    }

}


package pe.devpicon.android.myweatherapp.data

import pe.devpicon.android.myweatherapp.data.local.City
import pe.devpicon.android.myweatherapp.data.local.WeatherLocalDatasource
import pe.devpicon.android.myweatherapp.data.remote.WeatherRemoteDatasource

class WeatherRepository(private val localDatasource: WeatherLocalDatasource,
                        private val remoteDatasource: WeatherRemoteDatasource) {

    suspend fun search(searchText: String): List<City> {
        return remoteDatasource.search(searchText).map { City(it.weatherId, it.title) }
    }

    suspend fun saveCity(selectedCity: City) {
        localDatasource.saveCity(selectedCity)
    }

    suspend fun getStoredCityList(): List<City> {
        return localDatasource.getStoredCityList()
    }

    suspend fun isCityExist(id: Long): Boolean {
        return localDatasource.isCityExist(id)
    }
}
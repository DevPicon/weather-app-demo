package pe.devpicon.android.myweatherapp.data.local

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

sealed class Either<out ErrorType, out ResultType> {
    class Left<ErrorType>(val value: ErrorType) : Either<ErrorType, Nothing>()
    class Right<ResultType>(val value: ResultType) : Either<Nothing, ResultType>()
}

sealed class InsertResult<out T : Any> {
    object AlreadyExist : InsertResult<Nothing>()
    object NotFound : InsertResult<Nothing>()
}

class WeatherLocalDatasource(private val weatherDao: WeatherDao) {
    suspend fun getStoredCityList(): List<City> = withContext(Dispatchers.IO) {
        weatherDao.getStoredCities()
    }

    suspend fun saveCity(selectedCity: City) = withContext(Dispatchers.IO) {
        weatherDao.insert(selectedCity)
    }

    suspend fun isCityExist(id: Long): Boolean = withContext(Dispatchers.IO) {
        weatherDao.isCityExist(id)
    }
}
package pe.devpicon.android.myweatherapp.presentation.citylist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import pe.devpicon.android.myweatherapp.data.WeatherRepository
import pe.devpicon.android.myweatherapp.data.local.WeatherLocalDatasource
import pe.devpicon.android.myweatherapp.data.local.City

class CityListViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    fun getCityList(): LiveData<List<City>> =
            loadStoredCityList()

    private fun loadStoredCityList(): LiveData<List<City>> = liveData {
        val storedCityList = weatherRepository.getStoredCityList()
        emit(storedCityList)
    }
}
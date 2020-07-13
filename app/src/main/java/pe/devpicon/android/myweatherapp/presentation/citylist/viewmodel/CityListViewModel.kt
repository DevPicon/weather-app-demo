package pe.devpicon.android.myweatherapp.presentation.citylist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import pe.devpicon.android.myweatherapp.data.WeatherLocalRepository
import pe.devpicon.android.myweatherapp.data.local.City

class CityListViewModel : ViewModel() {

    fun getCityList(): LiveData<List<City>> =
            loadStoredCityList()

    private fun loadStoredCityList(): LiveData<List<City>> = liveData {
        val storedCityList = WeatherLocalRepository().getStoredCityList()
        emit(storedCityList)
    }
}
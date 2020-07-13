package pe.devpicon.android.myweatherapp.presentation

import pe.devpicon.android.myweatherapp.data.WeatherRepository
import pe.devpicon.android.myweatherapp.presentation.citylist.viewmodel.CityListViewModel
import pe.devpicon.android.myweatherapp.presentation.search.SearchViewModel

interface ViewModelFactory<out T> {
    fun create(): T
}

class SearchViewModelFactory(private val weatherRepository: WeatherRepository) : ViewModelFactory<SearchViewModel> {
    override fun create(): SearchViewModel {
        return SearchViewModel(weatherRepository)
    }

}

class CityListViewModelFactory(private val weatherRepository: WeatherRepository):ViewModelFactory<CityListViewModel>{
    override fun create(): CityListViewModel {
        return CityListViewModel(weatherRepository)
    }

}
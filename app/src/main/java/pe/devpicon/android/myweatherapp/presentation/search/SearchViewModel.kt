package pe.devpicon.android.myweatherapp.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pe.devpicon.android.myweatherapp.data.WeatherRepository
import pe.devpicon.android.myweatherapp.data.local.City

class SearchViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val searchText: MutableLiveData<String> = MutableLiveData("")
    lateinit var job: Deferred<List<City>>

    val result: LiveData<List<City>> = Transformations.switchMap(searchText) {
        liveData {
            if (this@SearchViewModel::job.isInitialized) {
                job.cancel()
            }
            if (it.isNotBlank()) {
                job = viewModelScope.async {
                    delay(2000)
                    weatherRepository.search(it)
                }
                emit(job.await())
            }
        }
    }


    fun search(param: String) {
        searchText.value = param
    }

    fun addSelectedCity(selectedCity: City): Unit {
        viewModelScope.launch {
            if (weatherRepository.isCityExist(selectedCity.id)) {

            } else {
                weatherRepository.saveCity(selectedCity)
            }

        }

    }
}
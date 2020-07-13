package pe.devpicon.android.myweatherapp.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import pe.devpicon.android.myweatherapp.data.WeatherRepository
import pe.devpicon.android.myweatherapp.data.local.City

@ExperimentalCoroutinesApi
class SearchViewModel : ViewModel() {

    private val searchText: MutableLiveData<String> = MutableLiveData("")
    lateinit var job: Job

    @FlowPreview
    val result: LiveData<List<City>> = Transformations.switchMap(searchText) {

        liveData<List<City>> {

            val deferredResult = viewModelScope.async {
                flowOf(it)
                        .debounce(1000)
                        .map { temp -> WeatherRepository().search(temp) }
                        .flowOn(Dispatchers.IO)
                        .map { responses -> responses.map { City(it.weatherId, it.title) } }
                        .collect()
            }
            emit(deferredResult.await())
        }
    }

    /*Transformations.map(searchText) { searchText ->
{
    var result = List<City>()
    job = viewModelScope.launch {
        result = WeatherRepository().search(searchText).map { City(it.weatherId, it.title) }
    }
}
}*/


    fun search(param: String) {
        searchText.value = param
    }
}
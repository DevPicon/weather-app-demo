package pe.devpicon.android.myweatherapp.presentation.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_search_city.*
import pe.devpicon.android.myweatherapp.R
import pe.devpicon.android.myweatherapp.WeatherApplication
import pe.devpicon.android.myweatherapp.presentation.SearchViewModelFactory

class SearchCityActivity : AppCompatActivity() {

    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_city)
        setSupportActionBar(findViewById(R.id.toolbar))

        val appContainer = (application as WeatherApplication).appContainer
        searchViewModel = SearchViewModelFactory(appContainer.weatherRepository).create()

        val tilSearchCity = til_search_city
        tilSearchCity.editText?.doOnTextChanged { text, start, before, count ->
            searchViewModel.search(text.toString())
        }

        searchViewModel.result.observe(this, Observer {
            if (it.isEmpty()) {
                mtv_search_no_result.visibility = View.VISIBLE
                rv_search_result.visibility = View.GONE
            } else {
                rv_search_result.adapter = SearchCityAdapter(it) { selectedCity ->
                    searchViewModel.addSelectedCity(selectedCity)
                }
                rv_search_result.layoutManager = LinearLayoutManager(this)

                mtv_search_no_result.visibility = View.GONE
                rv_search_result.visibility = View.VISIBLE
            }
        })
    }
}
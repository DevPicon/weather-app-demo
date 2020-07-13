package pe.devpicon.android.myweatherapp.presentation.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_search_city.*
import pe.devpicon.android.myweatherapp.R

class SearchCityActivity : AppCompatActivity() {

    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_city)

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        val tilSearchCity = til_search_city
        tilSearchCity.editText?.doOnTextChanged { text, start, before, count ->
            searchViewModel.search(text.toString())
        }
    }
}
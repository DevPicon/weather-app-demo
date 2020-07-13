package pe.devpicon.android.myweatherapp.presentation.citylist

import android.R.id
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_my_cities.*
import pe.devpicon.android.myweatherapp.R
import pe.devpicon.android.myweatherapp.WeatherApplication
import pe.devpicon.android.myweatherapp.presentation.CityListViewModelFactory
import pe.devpicon.android.myweatherapp.presentation.citylist.viewmodel.CityListViewModel
import pe.devpicon.android.myweatherapp.presentation.search.SearchCityActivity

class MyCitiesActivity : AppCompatActivity() {

    lateinit var cityListViewModel: CityListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cities)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        val appContainer = (application as WeatherApplication).appContainer
        cityListViewModel = CityListViewModelFactory(appContainer.weatherRepository).create()

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            startActivity(Intent(this, SearchCityActivity::class.java))
        }
        showCityList()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.getItemId() === id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        showCityList()
    }

    private fun showCityList() {
        cityListViewModel.getCityList().observe(this, Observer { cityList ->
            if (cityList.isEmpty()) {
                pb_city_list.visibility = View.GONE
                mtv_empty_list.visibility = View.VISIBLE
            } else {
                pb_city_list.visibility = View.GONE
                rv_selected_city_list.adapter = CityListAdapter(cityList)
                rv_selected_city_list.layoutManager = LinearLayoutManager(this)
                rv_selected_city_list.visibility = View.VISIBLE
            }
        })
    }
}
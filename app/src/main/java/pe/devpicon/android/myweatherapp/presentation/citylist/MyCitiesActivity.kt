package pe.devpicon.android.myweatherapp.presentation.citylist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.content_my_cities.*
import pe.devpicon.android.myweatherapp.R
import pe.devpicon.android.myweatherapp.presentation.citylist.viewmodel.CityListViewModel

class MyCitiesActivity : AppCompatActivity() {

    lateinit var cityListViewModel: CityListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cities)
        setSupportActionBar(findViewById(R.id.toolbar))

        cityListViewModel = ViewModelProvider(this).get(CityListViewModel::class.java)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        showCityList()
    }

    override fun onResume() {
        super.onResume()
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
package pe.devpicon.android.myweatherapp.presentation.landing

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import pe.devpicon.android.myweatherapp.R
import pe.devpicon.android.myweatherapp.presentation.citylist.MyCitiesActivity

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val btnAddCity = findViewById<Button>(R.id.btn_add_city)
        btnAddCity.setOnClickListener {
            val intent = Intent(this, MyCitiesActivity::class.java)
            startActivity(intent)
        }
    }
}
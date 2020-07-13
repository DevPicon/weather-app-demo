package pe.devpicon.android.myweatherapp.presentation.citylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import pe.devpicon.android.myweatherapp.R
import pe.devpicon.android.myweatherapp.R.layout
import pe.devpicon.android.myweatherapp.data.local.City

class CityListAdapter(var cityList: List<City>) : RecyclerView.Adapter<CityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder(LayoutInflater.from(parent.context).inflate(layout.item_city, parent, false))
    }

    override fun getItemCount(): Int = cityList.size

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cityList[position])
    }
}

class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(city: City) {
        itemView.findViewById<MaterialTextView>(R.id.mtv_city_name).text = city.name
    }

}
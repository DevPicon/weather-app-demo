package pe.devpicon.android.myweatherapp.presentation.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import pe.devpicon.android.myweatherapp.R
import pe.devpicon.android.myweatherapp.data.local.City

class SearchCityAdapter(var cityList: List<City>, val callback: (City) -> Unit) : RecyclerView.Adapter<SearchResultViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        return SearchResultViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_result_city, parent, false), callback)
    }

    override fun getItemCount(): Int = cityList.size

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        holder.bind(cityList[position])
    }
}

class SearchResultViewHolder(itemView: View, val callback: (City) -> Unit) : RecyclerView.ViewHolder(itemView) {
    fun bind(city: City) {
        itemView.findViewById<MaterialTextView>(R.id.mtv_city_name).text = city.name
        itemView.findViewById<ConstraintLayout>(R.id.cl_search_container).setOnClickListener { callback.invoke(city) }
    }
}
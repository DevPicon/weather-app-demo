package pe.devpicon.android.myweatherapp.data

import retrofit2.Retrofit

val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.metaweather.com/api/")
        .build()

val service: WeatherService = retrofit.create(WeatherService::class.java)
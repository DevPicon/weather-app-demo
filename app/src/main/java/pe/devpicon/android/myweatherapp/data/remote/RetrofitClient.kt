package pe.devpicon.android.myweatherapp.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import okhttp3.logging.HttpLoggingInterceptor.Level.BASIC
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val logging = HttpLoggingInterceptor().apply {
    setLevel(BASIC)
}.also {
    it.setLevel(Level.HEADERS)
}.also {
    it.setLevel(Level.BODY)
}

val httpClient = OkHttpClient.Builder().apply {
    addInterceptor(logging)
}

val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.metaweather.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build()

val service: WeatherService = retrofit.create(WeatherService::class.java)
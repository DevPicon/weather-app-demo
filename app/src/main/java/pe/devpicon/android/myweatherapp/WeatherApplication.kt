package pe.devpicon.android.myweatherapp

import android.app.Application
import android.content.Context
import pe.devpicon.android.myweatherapp.data.WeatherRepository
import pe.devpicon.android.myweatherapp.data.local.WeatherLocalDatasource
import pe.devpicon.android.myweatherapp.data.local.WeatherRoomDatabase
import pe.devpicon.android.myweatherapp.data.remote.WeatherRemoteDatasource
import pe.devpicon.android.myweatherapp.data.remote.service

class WeatherApplication : Application() {

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
    }


}

class AppContainer(applicationContext: Context) {
    private val weatherService = service
    private val weatherDatabase = WeatherRoomDatabase.getDatabase(applicationContext)
    private val remoteDatasource = WeatherRemoteDatasource(weatherService)
    private val localDatasource = WeatherLocalDatasource(weatherDatabase.weatherDao())

    val weatherRepository = WeatherRepository(localDatasource, remoteDatasource)
}

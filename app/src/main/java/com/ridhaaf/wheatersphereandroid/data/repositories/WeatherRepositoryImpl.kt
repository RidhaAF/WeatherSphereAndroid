package com.ridhaaf.wheatersphereandroid.data.repositories

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.ridhaaf.wheatersphereandroid.data.datasources.local.dao.WeatherDao
import com.ridhaaf.wheatersphereandroid.data.datasources.remote.api.WeatherApi
import com.ridhaaf.wheatersphereandroid.data.models.Weather
import com.ridhaaf.wheatersphereandroid.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class WeatherRepositoryImpl(
    private val api: WeatherApi,
    private val dao: WeatherDao,
) : WeatherRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun getWeather(lat: Double, lon: Double): Flow<Weather> = flow {
        try {
            val remoteGetWeather = api.getWeather(lat, lon)
            dao.deleteWeather(remoteGetWeather.toWeather())
            dao.insertWeather(remoteGetWeather.toWeather())
        } catch (e: HttpException) {
            emit(
                Weather.emptyWeather()
            )
        } catch (e: IOException) {
            emit(
                Weather.emptyWeather()
            )
        }

        val weather = dao.getWeather().toWeather()
        emit(weather)
    }
}
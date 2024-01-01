package com.ridhaaf.weathersphereandroid.data.repositories

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.ridhaaf.weathersphereandroid.data.datasources.local.dao.WeatherDao
import com.ridhaaf.weathersphereandroid.data.datasources.remote.api.WeatherApi
import com.ridhaaf.weathersphereandroid.data.models.Weather
import com.ridhaaf.weathersphereandroid.domain.repositories.WeatherRepository
import com.ridhaaf.weathersphereandroid.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class WeatherRepositoryImpl(
    private val api: WeatherApi,
    private val dao: WeatherDao,
) : WeatherRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun getWeather(lat: Double, lon: Double): Flow<Resource<Weather>> = flow {
        emit(Resource.Loading())

        try {
            val remoteGetWeather = api.getWeather(lat, lon)
            val data = remoteGetWeather.data.first().toWeather()
            dao.deleteWeather(data)
            dao.insertWeather(data)
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "Couldn't reach server. Check your internet connection"
                )
            )
        }

        val weather = dao.getWeather().toWeather()
        emit(Resource.Success(weather))
    }
}
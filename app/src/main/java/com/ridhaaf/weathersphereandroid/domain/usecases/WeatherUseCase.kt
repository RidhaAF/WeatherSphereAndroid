package com.ridhaaf.weathersphereandroid.domain.usecases

import android.content.Context
import com.ridhaaf.weathersphereandroid.data.models.Weather
import com.ridhaaf.weathersphereandroid.domain.repositories.WeatherRepository
import com.ridhaaf.weathersphereandroid.utils.Resource
import kotlinx.coroutines.flow.Flow

class WeatherUseCase(private val repository: WeatherRepository) {
    fun getWeather(lat: Double = 0.0, lon: Double = 0.0): Flow<Resource<Weather>> {
        return repository.getWeather(lat, lon)
    }

    fun getUserLocation(context: Context): Flow<Resource<Pair<Double, Double>>> {
        return repository.getUserLocation(context)
    }
}
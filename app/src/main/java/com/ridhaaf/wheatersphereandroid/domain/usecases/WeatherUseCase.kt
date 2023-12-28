package com.ridhaaf.wheatersphereandroid.domain.usecases

import com.ridhaaf.wheatersphereandroid.data.models.Weather
import com.ridhaaf.wheatersphereandroid.domain.repositories.WeatherRepository
import com.ridhaaf.wheatersphereandroid.utils.Resource
import kotlinx.coroutines.flow.Flow

class WeatherUseCase(private val repository: WeatherRepository) {
    fun getWeather(lat: Double = 0.0, lon: Double = 0.0): Flow<Resource<Weather>> {
        return repository.getWeather(lat, lon)
    }
}
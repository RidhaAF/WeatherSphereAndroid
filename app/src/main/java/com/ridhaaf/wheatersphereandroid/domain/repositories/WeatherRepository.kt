package com.ridhaaf.wheatersphereandroid.domain.repositories

import com.ridhaaf.wheatersphereandroid.data.models.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeather(lat: Double, lon: Double): Flow<Weather>
}
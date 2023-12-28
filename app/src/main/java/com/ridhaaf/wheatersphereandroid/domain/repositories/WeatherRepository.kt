package com.ridhaaf.wheatersphereandroid.domain.repositories

import com.ridhaaf.wheatersphereandroid.data.models.Weather
import com.ridhaaf.wheatersphereandroid.utils.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeather(lat: Double, lon: Double): Flow<Resource<Weather>>
}
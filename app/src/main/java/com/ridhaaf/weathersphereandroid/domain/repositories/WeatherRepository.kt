package com.ridhaaf.weathersphereandroid.domain.repositories

import android.content.Context
import com.ridhaaf.weathersphereandroid.data.models.Weather
import com.ridhaaf.weathersphereandroid.utils.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeather(lat: Double, lon: Double): Flow<Resource<Weather>>

    fun getUserLocation(context: Context): Flow<Resource<Pair<Double, Double>>>
}
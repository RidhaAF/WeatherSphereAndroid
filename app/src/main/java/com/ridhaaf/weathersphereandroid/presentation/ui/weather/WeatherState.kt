package com.ridhaaf.weathersphereandroid.presentation.ui.weather

import com.ridhaaf.weathersphereandroid.data.models.Weather

data class WeatherState(
    val isLoading: Boolean = false,
    val weather: Weather = Weather.emptyWeather(),
    val error: String = "",
)

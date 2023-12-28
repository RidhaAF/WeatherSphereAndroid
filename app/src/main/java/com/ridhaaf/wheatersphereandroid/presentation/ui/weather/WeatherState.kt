package com.ridhaaf.wheatersphereandroid.presentation.ui.weather

import com.ridhaaf.wheatersphereandroid.data.models.Weather

data class WeatherState(
    val isLoading: Boolean = false,
    val weather: Weather = Weather.emptyWeather(),
    val error: String = "",
)

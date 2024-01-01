package com.ridhaaf.weathersphereandroid.domain.entities

data class WeatherResponseEntity(
    val count: Int,
    val data: List<WeatherEntity>,
)

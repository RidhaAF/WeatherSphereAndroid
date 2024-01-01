package com.ridhaaf.weathersphereandroid.data.datasources.remote.dto

import com.google.gson.annotations.SerializedName

data class WeatherResponseDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("data")
    val data: List<WeatherDto>,
)

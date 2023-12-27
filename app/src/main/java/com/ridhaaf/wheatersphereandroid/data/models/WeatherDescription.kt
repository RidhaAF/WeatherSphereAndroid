package com.ridhaaf.wheatersphereandroid.data.models

data class WeatherDescription(
    val description: String,
    val code: Int,
    val icon: String,
) {
    companion object {
        fun emptyWeatherDescription() = WeatherDescription(
            description = "",
            code = 0,
            icon = "",
        )
    }
}
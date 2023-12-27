package com.ridhaaf.wheatersphereandroid.domain.entities

import com.ridhaaf.wheatersphereandroid.data.models.WeatherDescription

data class WeatherDescriptionEntity(
    val description: String,
    val code: Int,
    val icon: String,
) {
    companion object {
        fun fromWeatherDescription(weatherDescription: WeatherDescription): WeatherDescriptionEntity {
            return WeatherDescriptionEntity(
                description = weatherDescription.description,
                code = weatherDescription.code,
                icon = weatherDescription.icon,
            )
        }
    }

    fun toWeatherDescription(): WeatherDescription {
        return WeatherDescription(
            description = description,
            code = code,
            icon = icon,
        )
    }
}
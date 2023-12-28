package com.ridhaaf.wheatersphereandroid.data.datasources.remote.dto

import com.ridhaaf.wheatersphereandroid.domain.entities.WeatherDescriptionEntity

data class WeatherDescriptionDto(
    val description: String,
    val code: Int,
    val icon: String,
) {
//    companion object {
//        fun fromWeatherDescription(weatherDescription: WeatherDescription?): WeatherDescriptionEntity {
//            return WeatherDescriptionEntity(
//                description = weatherDescription?.description.orEmpty(),
//                code = weatherDescription?.code ?: 0,
//                icon = weatherDescription?.icon.orEmpty(),
//            )
//        }
//    }

    fun toWeatherDescription(): WeatherDescriptionEntity {
        return WeatherDescriptionEntity(
            description = description,
            code = code,
            icon = icon,
        )
    }
}

package com.ridhaaf.weathersphereandroid.data.datasources.remote.dto

import com.google.gson.annotations.SerializedName
import com.ridhaaf.weathersphereandroid.domain.entities.WeatherDescriptionEntity

data class WeatherDescriptionDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("code")
    val code: Int,
    @SerializedName("icon")
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

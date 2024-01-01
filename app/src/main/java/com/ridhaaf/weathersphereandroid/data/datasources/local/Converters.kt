package com.ridhaaf.weathersphereandroid.data.datasources.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ridhaaf.weathersphereandroid.domain.entities.WeatherDescriptionEntity

@ProvidedTypeConverter
class Converters {
    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromWeatherDescriptionEntity(weatherDescriptionEntity: WeatherDescriptionEntity): String {
        return Gson().toJson(weatherDescriptionEntity)
    }

    @TypeConverter
    fun toWeatherDescriptionEntity(value: String): WeatherDescriptionEntity {
        return Gson().fromJson(value, WeatherDescriptionEntity::class.java)
    }
}
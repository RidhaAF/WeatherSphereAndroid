package com.ridhaaf.weathersphereandroid.data.datasources.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ridhaaf.weathersphereandroid.data.datasources.local.Converters
import com.ridhaaf.weathersphereandroid.data.datasources.local.dao.WeatherDao
import com.ridhaaf.weathersphereandroid.domain.entities.WeatherEntity

@Database(
    entities = [WeatherEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converters::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract val dao: WeatherDao
}
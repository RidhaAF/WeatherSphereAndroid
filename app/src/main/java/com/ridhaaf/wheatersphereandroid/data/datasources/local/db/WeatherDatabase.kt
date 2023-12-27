package com.ridhaaf.wheatersphereandroid.data.datasources.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ridhaaf.wheatersphereandroid.data.datasources.local.Converters
import com.ridhaaf.wheatersphereandroid.data.datasources.local.dao.WeatherDao
import com.ridhaaf.wheatersphereandroid.domain.entities.WeatherEntity

@Database(
    entities = [WeatherEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converters::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract val dao: WeatherDao
}
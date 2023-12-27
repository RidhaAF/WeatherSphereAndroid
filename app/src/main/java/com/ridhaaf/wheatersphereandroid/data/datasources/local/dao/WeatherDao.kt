package com.ridhaaf.wheatersphereandroid.data.datasources.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ridhaaf.wheatersphereandroid.domain.entities.WeatherEntity

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: WeatherEntity)

    @Delete
    suspend fun deleteWeather(weather: WeatherEntity)

    @Query("SELECT * FROM weather")
    suspend fun getWeather(): WeatherEntity
}
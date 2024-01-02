package com.ridhaaf.weathersphereandroid.data.datasources.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ridhaaf.weathersphereandroid.domain.entities.WeatherEntity

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: WeatherEntity)

    @Query("DELETE FROM weather")
    suspend fun deleteWeather()

    @Query("SELECT * FROM weather")
    suspend fun getWeather(): WeatherEntity
}
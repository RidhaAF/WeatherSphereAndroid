package com.ridhaaf.wheatersphereandroid.data.datasources.remote.api

import com.ridhaaf.wheatersphereandroid.BuildConfig
import com.ridhaaf.wheatersphereandroid.data.datasources.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("current")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("key") apiKey: String = BuildConfig.API_KEY,
    ): WeatherDto
}
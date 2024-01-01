package com.ridhaaf.weathersphereandroid.data.datasources.remote.api

import com.ridhaaf.weathersphereandroid.BuildConfig
import com.ridhaaf.weathersphereandroid.data.datasources.remote.dto.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("current")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("key") apiKey: String = BuildConfig.API_KEY,
    ): WeatherResponseDto
}
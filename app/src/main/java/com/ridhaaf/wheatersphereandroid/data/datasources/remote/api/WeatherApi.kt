package com.ridhaaf.wheatersphereandroid.data.datasources.remote.api

import com.ridhaaf.wheatersphereandroid.data.datasources.remote.dto.WeatherDto
import com.ridhaaf.wheatersphereandroid.utils.AppConfig
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    @GET("current?lat={lat}&lon={lon}&key={apiKey}")
    suspend fun getWeather(
        @Path("lat") lat: Double,
        @Path("lon") lon: Double,
        @Path("apiKey") apiKey: String = AppConfig.apiKey,
    ): WeatherDto
}
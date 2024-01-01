package com.ridhaaf.weathersphereandroid.di

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.ridhaaf.weathersphereandroid.BuildConfig
import com.ridhaaf.weathersphereandroid.data.datasources.local.Converters
import com.ridhaaf.weathersphereandroid.data.datasources.local.db.WeatherDatabase
import com.ridhaaf.weathersphereandroid.data.datasources.remote.api.WeatherApi
import com.ridhaaf.weathersphereandroid.data.repositories.WeatherRepositoryImpl
import com.ridhaaf.weathersphereandroid.domain.repositories.WeatherRepository
import com.ridhaaf.weathersphereandroid.domain.usecases.WeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherModule {
    @Provides
    @Singleton
    fun provideWeatherUseCase(repository: WeatherRepository): WeatherUseCase {
        return WeatherUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(
        api: WeatherApi,
        db: WeatherDatabase,
    ): WeatherRepository {
        return WeatherRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWeatherDatabase(app: Application): WeatherDatabase {
        return Room.databaseBuilder(
            app,
            WeatherDatabase::class.java,
            "weather_db",
        ).addTypeConverter(Converters()).build()
    }

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}
package com.ridhaaf.wheatersphereandroid.di

import android.app.Application
import androidx.room.Room
import com.ridhaaf.wheatersphereandroid.data.datasources.local.Converters
import com.ridhaaf.wheatersphereandroid.data.datasources.local.db.WeatherDatabase
import com.ridhaaf.wheatersphereandroid.data.datasources.remote.api.WeatherApi
import com.ridhaaf.wheatersphereandroid.data.repositories.WeatherRepositoryImpl
import com.ridhaaf.wheatersphereandroid.domain.repositories.WeatherRepository
import com.ridhaaf.wheatersphereandroid.domain.usecases.WeatherUseCase
import com.ridhaaf.wheatersphereandroid.utils.AppConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
            .baseUrl(AppConfig.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}
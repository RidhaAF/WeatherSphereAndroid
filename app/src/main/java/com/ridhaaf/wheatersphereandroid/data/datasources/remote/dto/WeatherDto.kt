package com.ridhaaf.wheatersphereandroid.data.datasources.remote.dto

import com.ridhaaf.wheatersphereandroid.domain.entities.WeatherEntity

data class WeatherDto(
    val id: Long = 0,
    val appTemp: Double,
    val aqi: Int,
    val cityName: String,
    val clouds: Int,
    val countryCode: String,
    val datetime: String,
    val dewpt: Int,
    val dhi: Double,
    val dni: Double,
    val elevAngle: Double,
    val ghi: Double,
    val gust: Double,
    val hAngle: Int,
    val lat: Double,
    val lon: Double,
    val obTime: String,
    val pod: String,
    val precip: Double,
    val pres: Double,
    val rh: Int,
    val slp: Double,
    val snow: Int,
    val solarRad: Double,
    val sources: List<String>,
    val stateCode: String,
    val station: String,
    val sunrise: String,
    val sunset: String,
    val temp: Double,
    val timezone: String,
    val ts: Int,
    val uv: Double,
    val vis: Int,
    val weather: WeatherDescriptionDto,
    val windCdir: String,
    val windCdirFull: String,
    val windDir: Int,
    val windSpd: Double,
) {
//    companion object {
//        fun fromWeather(weather: Weather): WeatherEntity {
//            return WeatherEntity(
//                id = weather.id,
//                appTemp = weather.appTemp,
//                aqi = weather.aqi,
//                cityName = weather.cityName,
//                clouds = weather.clouds,
//                countryCode = weather.countryCode,
//                datetime = weather.datetime,
//                dewpt = weather.dewpt,
//                dhi = weather.dhi,
//                dni = weather.dni,
//                elevAngle = weather.elevAngle,
//                ghi = weather.ghi,
//                gust = weather.gust,
//                hAngle = weather.hAngle,
//                lat = weather.lat,
//                lon = weather.lon,
//                obTime = weather.obTime,
//                pod = weather.pod,
//                precip = weather.precip,
//                pres = weather.pres,
//                rh = weather.rh,
//                slp = weather.slp,
//                snow = weather.snow,
//                solarRad = weather.solarRad,
//                sources = weather.sources,
//                stateCode = weather.stateCode,
//                station = weather.station,
//                sunrise = weather.sunrise,
//                sunset = weather.sunset,
//                temp = weather.temp,
//                timezone = weather.timezone,
//                ts = weather.ts,
//                uv = weather.uv,
//                vis = weather.vis,
//                weather = weather.weather.let { WeatherDescriptionEntity.fromWeatherDescription(it)  },
//                windCdir = weather.windCdir,
//                windCdirFull = weather.windCdirFull,
//                windDir = weather.windDir,
//                windSpd = weather.windSpd,
//            )
//        }
//    }

    fun toWeather(): WeatherEntity {
        return WeatherEntity(
            id = id,
            appTemp = appTemp,
            aqi = aqi,
            cityName = cityName,
            clouds = clouds,
            countryCode = countryCode,
            datetime = datetime,
            dewpt = dewpt,
            dhi = dhi,
            dni = dni,
            elevAngle = elevAngle,
            ghi = ghi,
            gust = gust,
            hAngle = hAngle,
            lat = lat,
            lon = lon,
            obTime = obTime,
            pod = pod,
            precip = precip,
            pres = pres,
            rh = rh,
            slp = slp,
            snow = snow,
            solarRad = solarRad,
            sources = sources,
            stateCode = stateCode,
            station = station,
            sunrise = sunrise,
            sunset = sunset,
            temp = temp,
            timezone = timezone,
            ts = ts,
            uv = uv,
            vis = vis,
            weather = weather.toWeatherDescription(),
            windCdir = windCdir,
            windCdirFull = windCdirFull,
            windDir = windDir,
            windSpd = windSpd,
        )
    }
}
package com.ridhaaf.weathersphereandroid.data.datasources.remote.dto

import com.google.gson.annotations.SerializedName
import com.ridhaaf.weathersphereandroid.domain.entities.WeatherEntity

data class WeatherDto(
    val id: Long = 0,
    @SerializedName("app_temp")
    val appTemp: Double,
    @SerializedName("aqi")
    val aqi: Int,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("clouds")
    val clouds: Int,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("dewpt")
    val dewpt: Double,
    @SerializedName("dhi")
    val dhi: Double,
    @SerializedName("dni")
    val dni: Double,
    @SerializedName("elev_angle")
    val elevAngle: Double,
    @SerializedName("ghi")
    val ghi: Double,
    @SerializedName("gust")
    val gust: Double,
    @SerializedName("h_angle")
    val hAngle: Int,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("ob_time")
    val obTime: String,
    @SerializedName("pod")
    val pod: String,
    @SerializedName("precip")
    val precip: Double,
    @SerializedName("pres")
    val pres: Double,
    @SerializedName("rh")
    val rh: Int,
    @SerializedName("slp")
    val slp: Double,
    @SerializedName("snow")
    val snow: Int,
    @SerializedName("solar_rad")
    val solarRad: Double,
    @SerializedName("sources")
    val sources: List<String>,
    @SerializedName("state_code")
    val stateCode: String,
    @SerializedName("station")
    val station: String,
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("ts")
    val ts: Int,
    @SerializedName("uv")
    val uv: Double,
    @SerializedName("vis")
    val vis: Int,
    @SerializedName("weather")
    val weather: WeatherDescriptionDto,
    @SerializedName("wind_cdir")
    val windCdir: String,
    @SerializedName("wind_cdir_full")
    val windCdirFull: String,
    @SerializedName("wind_dir")
    val windDir: Int,
    @SerializedName("wind_spd")
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
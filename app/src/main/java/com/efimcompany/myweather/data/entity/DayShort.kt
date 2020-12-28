package com.efimcompany.myweather.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DayShort(

    @SerialName("condition")
    val condition: String?,
    @SerialName("feels_like")
    val feelsLike: Int?,
    @SerialName("humidity")
    val humidity: Int?,
    @SerialName("pressure_mm")
    val pressureMm: Int?,
    @SerialName("temp")
    val temp: Int?,
    @SerialName("wind_dir")
    val windDir: String?,
    @SerialName("wind_gust")
    val windGust: Double?,
    @SerialName("wind_speed")
    val windSpeed: Double?
)
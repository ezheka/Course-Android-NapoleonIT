package com.efimcompany.myweather.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Day(
    @SerialName("cloudness")
    val cloudness: Double?,
    @SerialName("condition")
    val condition: String?,
    @SerialName("daytime")
    val daytime: String?,
    @SerialName("feels_like")
    val feelsLike: Int?,
    @SerialName("humidity")
    val humidity: Int?,
    @SerialName("icon")
    val icon: String?,
    @SerialName("polar")
    val polar: Boolean?,
    @SerialName("prec_mm")
    val precMm: Double?,
    @SerialName("prec_period")
    val precPeriod: Int?,
    @SerialName("prec_prob")
    val precProb: Int?,
    @SerialName("prec_strength")
    val precStrength: Double?,
    @SerialName("prec_type")
    val precType: Int?,
    @SerialName("pressure_mm")
    val pressureMm: Int?,
    @SerialName("pressure_pa")
    val pressurePa: Int?,
    @SerialName("soil_moisture")
    val soilMoisture: Double?,
    @SerialName("soil_temp")
    val soilTemp: Int?,
    @SerialName("_source")
    val source: String?,
    @SerialName("temp_avg")
    val tempAvg: Int?,
    @SerialName("temp_max")
    val tempMax: Int?,
    @SerialName("temp_min")
    val tempMin: Int?,
    @SerialName("uv_index")
    val uvIndex: Int?,
    @SerialName("wind_dir")
    val windDir: String?,
    @SerialName("wind_gust")
    val windGust: Double?,
    @SerialName("wind_speed")
    val windSpeed: Int?
)
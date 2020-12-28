package com.efimcompany.myweather.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("forecasts")
    val forecasts: List<Forecast>?,
    @SerialName("geo_object")
    val geoObject: GeoObject?,
    @SerialName("info")
    val info: Info?
)
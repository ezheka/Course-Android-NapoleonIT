package com.efimcompany.myweather.data.entity.weatherApi


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Forecast(
    @SerialName("date")
    val date: String?,
    @SerialName("parts")
    val parts: Parts?,
)
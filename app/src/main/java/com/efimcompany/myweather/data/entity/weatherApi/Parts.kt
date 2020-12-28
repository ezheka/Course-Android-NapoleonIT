package com.efimcompany.myweather.data.entity.weatherApi


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Parts(
    @SerialName("day_short")
    val dayShort: DayShort?
)
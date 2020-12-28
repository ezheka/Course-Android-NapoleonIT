package com.efimcompany.myweather.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Forecast(
    @SerialName("date")
    val date: String?,
    @SerialName("parts")
    val parts: Parts?,
)
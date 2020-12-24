package com.efimcompany.myweather.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Yesterday(
    @SerialName("temp")
    val temp: Int?
)
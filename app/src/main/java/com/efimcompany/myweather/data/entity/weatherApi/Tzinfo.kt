package com.efimcompany.myweather.data.entity.weatherApi


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tzinfo(
    @SerialName("abbr")
    val abbr: String?,
    @SerialName("dst")
    val dst: Boolean?,
    @SerialName("name")
    val name: String?,
    @SerialName("offset")
    val offset: Int?
)
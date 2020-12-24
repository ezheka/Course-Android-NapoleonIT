package com.efimcompany.myweather.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeoObject(
    @SerialName("country")
    val country: Country?,
    @SerialName("locality")
    val locality: Locality?,
    @SerialName("province")
    val province: Province?
)
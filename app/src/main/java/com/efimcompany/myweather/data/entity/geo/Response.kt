package com.efimcompany.myweather.data.entity.geo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("GeoObjectCollection")
    val geoObjectCollection: GeoObjectCollection?
)
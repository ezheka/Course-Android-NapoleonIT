package com.efimcompany.myweather.data.entity.geocoderApi


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("GeoObjectCollection")
    val geoObjectCollection: GeoObjectCollection?
)
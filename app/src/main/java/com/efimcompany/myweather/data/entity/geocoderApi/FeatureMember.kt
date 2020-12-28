package com.efimcompany.myweather.data.entity.geocoderApi


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FeatureMember(
    @SerialName("GeoObject")
    val geoObject: GeoObject?
)
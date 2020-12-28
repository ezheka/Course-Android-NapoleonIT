package com.efimcompany.myweather.data.entity.geocoderApi


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeoObjectCollection(
    @SerialName("featureMember")
    val featureMember: List<FeatureMember>?
)
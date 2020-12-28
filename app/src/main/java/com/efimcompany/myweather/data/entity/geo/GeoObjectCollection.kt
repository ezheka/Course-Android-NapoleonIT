package com.efimcompany.myweather.data.entity.geo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeoObjectCollection(
    @SerialName("featureMember")
    val featureMember: List<FeatureMember>?
)
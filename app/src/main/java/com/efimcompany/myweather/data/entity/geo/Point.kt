package com.efimcompany.myweather.data.entity.geo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Point(
    @SerialName("pos")
    val pos: String?
)
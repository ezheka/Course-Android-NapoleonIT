package com.efimcompany.myweather.data.entity.weatherApi


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Province(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?
)
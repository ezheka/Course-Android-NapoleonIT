package com.efimcompany.myweather.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Locality(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?
)
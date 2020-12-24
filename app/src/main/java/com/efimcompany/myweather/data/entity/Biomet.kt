package com.efimcompany.myweather.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Biomet(
    @SerialName("condition")
    val condition: String?,
    @SerialName("index")
    val index: Int?
)
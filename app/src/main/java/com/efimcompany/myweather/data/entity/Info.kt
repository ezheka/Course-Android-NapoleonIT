package com.efimcompany.myweather.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Info(
    @SerialName("def_pressure_mm")
    val defPressureMm: Int?,
    @SerialName("def_pressure_pa")
    val defPressurePa: Int?,
    @SerialName("f")
    val f: Boolean?,
    @SerialName("geoid")
    val geoid: Int?,
    @SerialName("_h")
    val h: Boolean?,
    @SerialName("lat")
    val lat: Double?,
    @SerialName("lon")
    val lon: Double?,
    @SerialName("n")
    val n: Boolean?,
    @SerialName("nr")
    val nr: Boolean?,
    @SerialName("ns")
    val ns: Boolean?,
    @SerialName("nsr")
    val nsr: Boolean?,
    @SerialName("p")
    val p: Boolean?,
    @SerialName("slug")
    val slug: String?,
    @SerialName("tzinfo")
    val tzinfo: Tzinfo?,
    @SerialName("url")
    val url: String?,
    @SerialName("zoom")
    val zoom: Int?
)
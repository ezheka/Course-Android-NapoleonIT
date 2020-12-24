package com.efimcompany.myweather.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Parts(
    @SerialName("day")
    val day: Day?,
    @SerialName("day_short")
    val dayShort: DayShort?,
    @SerialName("evening")
    val evening: Evening?,
    @SerialName("morning")
    val morning: Morning?,
    @SerialName("night")
    val night: Night?,
    @SerialName("night_short")
    val nightShort: NightShort?
)
package com.efimcompany.myweather.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Forecast(
    @SerialName("biomet")
    val biomet: Biomet?,
    @SerialName("date")
    val date: String?,
    @SerialName("date_ts")
    val dateTs: Int?,
    @SerialName("hours")
    val hours: List<Hour>?,
    @SerialName("moon_code")
    val moonCode: Int?,
    @SerialName("moon_text")
    val moonText: String?,
    @SerialName("parts")
    val parts: Parts?,
    @SerialName("rise_begin")
    val riseBegin: String?,
    @SerialName("set_end")
    val setEnd: String?,
    @SerialName("sunrise")
    val sunrise: String?,
    @SerialName("sunset")
    val sunset: String?,
    @SerialName("week")
    val week: Int?
)
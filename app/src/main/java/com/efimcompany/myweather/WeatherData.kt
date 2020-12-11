package com.efimcompany.myweather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherData(val date: String, val temp:Int, val temp_2:Int): Parcelable

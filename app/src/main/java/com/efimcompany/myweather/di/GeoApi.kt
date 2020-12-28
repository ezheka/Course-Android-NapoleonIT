package com.efimcompany.myweather.di

import com.efimcompany.myweather.data.entity.geocoderApi.GeoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoApi {
    @GET("1.x/")
    suspend fun getGeo(
        @Query("format") format:String = "json",
        @Query("apikey") apikey:String = "c89e8a63-acf8-42f3-b555-d396295960e8",
        @Query("geocode") geocode:String
    ): GeoResponse
}
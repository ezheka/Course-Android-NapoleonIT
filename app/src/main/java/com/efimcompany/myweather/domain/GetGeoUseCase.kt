package com.efimcompany.myweather.domain

import com.efimcompany.myweather.GeoData
import com.efimcompany.myweather.di.GeoApi


class GetGeoUseCase(private val geoApi: GeoApi, private val cityName: String) {

    suspend operator fun invoke(): List<GeoData>{
        val respons =  geoApi.getGeo(geocode = cityName)
        return respons.run {
            response?.geoObjectCollection?.featureMember?.mapNotNull { resp ->
                GeoData(
                    coordinates = resp.geoObject?.point?.pos ?:return@mapNotNull null
                )
            } ?: emptyList()
        }
    }
}
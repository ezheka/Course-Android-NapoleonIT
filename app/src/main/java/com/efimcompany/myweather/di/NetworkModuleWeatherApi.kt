package com.efimcompany.myweather.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create

val weatherApi: WeatherApi = Retrofit.Builder()
    .baseUrl("https://api.weather.yandex.ru/")
    .client(OkHttpClient.Builder().addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("X-Yandex-API-Key", "01cee637-437f-4881-9fa4-aab0bf846391").build()
        chain.proceed(request)
    }.build())
    .addConverterFactory(Json(builderAction = {
        ignoreUnknownKeys = true
    }).asConverterFactory("application/json".toMediaType()))
    .build()
    .create()
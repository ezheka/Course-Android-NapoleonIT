package com.efimcompany.myweather

data class JsonYandexAPI(val forecasts: List<Forecasts>) {
}

data class Forecasts(val date: String = "", val parts: Parts){
}

class Parts(val day_short: Day)
{
}

class Day(val temp: Int, val temp_min: Int, val feels_like: Int,
          val condition: String,
          val wind_speed: Double, val wind_gust: Double, val wind_dir: String,
          val pressure_mm: Int, val humidity: Int)
{
}

fun descriptionWeather(str:String): String {
    var descript: String = ""
    if (str == "clear") descript = "ясно"
    if (str == "partly-cloudy") descript = "малооблачно"
    if (str == "cloudy") descript = "облачно с прояснениями"
    if (str == "overcast") descript = "пасмурно"
    if (str == "drizzle") descript = "морось"
    if (str == "light-rain") descript = "небольшой дождь"
    if (str == "rain") descript = "дождь"
    if (str == "moderate-rain") descript = "умеренно сильный дождь"
    if (str == "heavy-rain") descript = "сильный дождь"
    if (str == "continuous-heavy-rain") descript = "длительный сильный дождь"
    if (str == "showers") descript = "ливень"
    if (str == "wet-snow") descript = "дождь со снегом"
    if (str == "light-snow") descript = "небольшой снег"
    if (str == "snow") descript = "снег"
    if (str == "snow-showers") descript = "снегопад"
    if (str == "hail") descript = "град"
    if (str == "thunderstorm") descript = "гроза"
    if (str == "thunderstorm-with-rain") descript = "дождь с грозой"
    if (str == "thunderstorm-with-hail") descript = "гроза с градом"

    return descript
}

fun windDirection(str:String): String {
    var wind: String = ""
    if (str == "nw") wind = " северо-западное"
    if (str == "n") wind = "северное"
    if (str == "ne") wind = "северо-восточное"
    if (str == "e") wind = "восточное"
    if (str == "se") wind = "юго-восточное"
    if (str == "s") wind = "южное"
    if (str == "sw") wind = "юго-западное"
    if (str == "w") wind = "западное"
    if (str == "с") wind = "штиль"

    return wind
}
package com.efimcompany.myweather

//import com.google.gson.Gson
//import khttp.get

/*
Работа с погодой
 */
data class JsonYandexAPI(val forecasts: List<Forecasts>) {
}

data class Forecasts(val date: String = "", val parts: Parts){
}

data class Parts(val day_short: Day)
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


fun geopositionCity(){
    /*val resp = get(
        url = "https://geocode-maps.yandex.ru/1.x/",
        params = mapOf("format" to "json", "apikey" to "c89e8a63-acf8-42f3-b555-d396295960e8", "geocode" to "Еткуль")
    )

    //println(resp.text)

    val geoAPIYandex = Gson().fromJson(resp.text, GeoAPIYandex::class.java)

    val geocity = writeCityName(geoAPIYandex.response.GeoObjectCollection.featureMember[0].GeoObject.metaDataProperty.GeocoderMetaData.Address.Components)
    val geopos = geoAPIYandex.response.GeoObjectCollection.featureMember[0].GeoObject.Point.pos

    val geoPosPars = geopos.split(" ")

    val lon = geoPosPars[0]
    val lat = geoPosPars[1]

     */
}

/*
Работа с геолокацией
 */

data class GeoAPIYandex(val response:Response){
}

data class  Response(val GeoObjectCollection:GeoObjectCollection){
}

data class GeoObjectCollection(val featureMember: List<FeatureMember>){
}

data class FeatureMember(val GeoObject: GeoObject){
}

data class GeoObject(val metaDataProperty: MetaDataProperty, val Point: Point){
}

data class MetaDataProperty(val GeocoderMetaData:GeocoderMetaData){
}

data class GeocoderMetaData(val Address:Address){
}

data class Address(val Components:List<Components>){
}

data class Components(val kind:String, val name:String){
}

data class Point(val pos:String){
}


fun writeCityName(components: List<Components>):String{

    var city: String = "Москва"

    for (i in 0..components.lastIndex){
       if(components[i].kind=="province") {
           city=components[i].name
       }
        if(components[i].kind=="locality") {
            city=components[i].name
        }
   }

    return city
}

/*
{
    "response": {
        "GeoObjectCollection": {
            "metaDataProperty": {
                "GeocoderResponseMetaData": {
                    "request": "Москва, улица Новый Арбат, дом 24",
                    "found": "1",
                    "results": "10"
                }
            },
            "featureMember": [
            {
                "GeoObject": {
                "metaDataProperty": {
                    "GeocoderMetaData": {
                        "kind": "house",
                        "text": "Россия, Москва, улица Новый Арбат, 24",
                        "precision": "exact",
                        "Address": {
                        "country_code": "RU",
                        "postal_code": "119019",
                        "formatted": "Москва, улица Новый Арбат, 24",
                        "Components": [
                        {
                            "kind": "country",
                            "name": "Россия"
                        },
                        {
                            "kind": "province",
                            "name": "Центральный федеральный округ"
                        },
                        {
                            "kind": "province",
                            "name": "Москва"
                        },
                        {
                            "kind": "locality",
                            "name": "Москва"
                        },
                        {
                            "kind": "street",
                            "name": "улица Новый Арбат"
                        },
                        {
                            "kind": "house",
                            "name": "24"
                        }
                        ]
                        },
                        "AddressDetails": {
                        "Country": {
                        "AddressLine": "Москва, улица Новый Арбат, 24",
                        "CountryNameCode": "RU",
                        "CountryName": "Россия",
                        "AdministrativeArea": {
                        "AdministrativeAreaName": "Москва",
                        "Locality": {
                        "LocalityName": "Москва",
                        "Thoroughfare": {
                        "ThoroughfareName": "улица Новый Арбат",
                        "Premise": {
                        "PremiseNumber": "24",
                        "PostalCode": {
                        "PostalCodeNumber": "119019"
                    }
                    }
                    }
                    }
                    }
                    }
                    }
                    }
            },
                "description": "Москва, Россия",
                "name": "улица Новый Арбат, 24",
                "boundedBy": {
                "Envelope": {
                "lowerCorner": "37.583508 55.750768",
                "upperCorner": "37.591719 55.755398"
            }
            },
                "Point": {
                "pos": "37.587614 55.753083"
            }
        }
    }
    ]
}
}
}
*/
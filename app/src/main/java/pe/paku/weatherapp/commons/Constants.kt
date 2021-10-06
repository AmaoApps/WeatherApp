package pe.paku.weatherapp.commons

object Constants {

    val EMPTY_STRING: String = ""
    val BASE_URL_WEATHER : String =  "https://weather.exam.bottlerocketservices.com/";

    object PathScreen {
        val HOME_WEATHER : String = "home_weather"
        val IMAGE_WEATHER: String = "image_weather"
    }

    object WeatherType {
        val SUNNY: String  = "sunny"
        val PARTY_CLOUDY: String = "partlyCloudy"
        val SNOW_SLEET: String = "snowSleet"
        val HEAVY_RAIN: String = "heavyRain"
        val LIGHT_RAIN: String = "lightRain"
        val CLOUDY: String = "cloudy"
    }

    object WeatherFeature {
        val TIME : String = "Time"
        val TEMP : String = "Temp"
        val CHANCE_RAIN : String = "Chance\nof rain"
        val WIND : String = "Wind\n(mph)"
        val HUMIDITY : String = "Humidity"
    }
}
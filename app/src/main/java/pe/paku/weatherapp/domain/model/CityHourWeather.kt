package pe.paku.weatherapp.domain.model

data class CityHourWeather(
    val hour: Int,
    val temperatura: Int,
    val weatherType: String,
    val rainChance: Int,
    val humidity: Double,
    val windSpeed: Int
)

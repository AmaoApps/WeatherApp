package pe.paku.weatherapp.domain.model

data class CityHourWeather(
    val hour: Int,
    val temperatura: Int,
    val weatherType: String,
    val rainChance: Double,
    val humidity: Double,
    val windSpeed: Double
)

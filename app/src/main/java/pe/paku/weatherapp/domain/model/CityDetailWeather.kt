package pe.paku.weatherapp.domain.model

data class CityDetailWeather(
    val city: City,
    val days: List<CityDayWeather>
)

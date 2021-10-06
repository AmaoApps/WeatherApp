package pe.paku.weatherapp.domain.model

data class CityDayWeather(
    val dayOfWeek: Int,
    val hourly: List<CityHourWeather> = emptyList(),
    val temperature: Int,
    val weatherType: String
)

package pe.paku.weatherapp.presentation.home_weather

import pe.paku.weatherapp.domain.model.City
import pe.paku.weatherapp.domain.model.CityDetailWeather

data class HomeWeatherState(
    val isLoading: Boolean = false,
    val city: City = City(),
    val detailCity: CityDetailWeather = CityDetailWeather(),
    val error: String = ""
)

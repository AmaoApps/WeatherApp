package pe.paku.weatherapp.data.repository

import pe.paku.weatherapp.data.remote.WeatherApi
import pe.paku.weatherapp.data.remote.dto.ResponseDetailDTO
import pe.paku.weatherapp.data.remote.dto.ResponseSearchDTO
import pe.paku.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getCitiesBySearch(cityName: String): ResponseSearchDTO {
        return api.getCitiesBySearch(city = cityName)
    }

    override suspend fun getCityDetailById(idCity: String): ResponseDetailDTO {
        return api.getDetailCityById(idCity = idCity)
    }

}
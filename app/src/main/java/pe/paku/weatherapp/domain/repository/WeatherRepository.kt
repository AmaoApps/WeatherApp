package pe.paku.weatherapp.domain.repository

import pe.paku.weatherapp.data.remote.dto.ResponseDetailDTO
import pe.paku.weatherapp.data.remote.dto.ResponseSearchDTO

interface WeatherRepository {

    suspend fun getCitiesBySearch(cityName: String): ResponseSearchDTO

    suspend fun getCityDetailById(idCity: String): ResponseDetailDTO
}
package pe.paku.weatherapp.data.remote

import pe.paku.weatherapp.data.remote.dto.ResponseDetailDTO
import pe.paku.weatherapp.data.remote.dto.ResponseSearchDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {

    @GET("cities")
    suspend fun getCitiesBySearch(@Query("search") city: String) : ResponseSearchDTO

    @GET("cities/{idCity}")
    suspend fun getDetailCityById(@Path("idCity") idCity: String) : ResponseDetailDTO

}
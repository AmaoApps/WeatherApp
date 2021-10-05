package pe.paku.weatherapp.domain.usecases.get_detail_city

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pe.paku.weatherapp.commons.Resource
import pe.paku.weatherapp.domain.model.CityDetailWeather
import pe.paku.weatherapp.domain.repository.WeatherRepository
import pe.paku.weatherapp.domain.repository.converters.toCityDetailWeather
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDetailCityUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    operator fun invoke(idCity: String) : Flow<Resource<CityDetailWeather>> = flow {

        try {
            emit(Resource.Loading())
            val weatherCityDetail = repository.getCityDetailById(idCity = idCity)
            emit(Resource.Success<CityDetailWeather>(weatherCityDetail.toCityDetailWeather()))
        } catch (e: HttpException){
            emit(Resource.Error<CityDetailWeather>("Ocurrió un error inesperado"))
        } catch (e: IOException){
            emit(Resource.Error<CityDetailWeather>("Ocurrió un error en la conexión, intente más tarde"))
        }


    }

}
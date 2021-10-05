package pe.paku.weatherapp.domain.usecases.get_search_by_city

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pe.paku.weatherapp.commons.Resource
import pe.paku.weatherapp.domain.model.City
import pe.paku.weatherapp.domain.repository.WeatherRepository
import pe.paku.weatherapp.domain.repository.converters.toCity
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSearchByCityUseCase @Inject constructor(
    private val repository: WeatherRepository
){

    operator fun invoke(cityName: String) : Flow<Resource<City>> = flow {
        try {
            emit(Resource.Loading())
            val city = repository.getCitiesBySearch(cityName = cityName)
            city.toCity()?.let {
                emit(Resource.Success<City>(it))
            } ?: emit(Resource.Error("No se encontró el nombre de la ciudad"))

        } catch (e: HttpException) {
            emit(Resource.Error<City>("Ocurrió un problema inesperado"))
        } catch (e: IOException){
            emit(Resource.Error<City>("Ocurrió un problema de conexión"))
        }
    }

}
package pe.paku.weatherapp.presentation.home_weather

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pe.paku.weatherapp.commons.Resource
import pe.paku.weatherapp.domain.usecases.get_detail_city.GetDetailCityUseCase
import pe.paku.weatherapp.domain.usecases.get_search_by_city.GetSearchByCityUseCase
import javax.inject.Inject

@HiltViewModel
class HomeWeatherViewModel @Inject constructor(
    private val getSearchByCityUseCase: GetSearchByCityUseCase,
    private val getDetailCityUseCase: GetDetailCityUseCase
) : ViewModel() {

    private val _state = mutableStateOf(HomeWeatherState())
    val state : State<HomeWeatherState> = _state

    init {
        getCitySearching(nameCity = "Calera")
    }

    private fun getCitySearching(nameCity : String){
        getSearchByCityUseCase.invoke(cityName = nameCity).onEach { result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = HomeWeatherState(isLoading = true)
                }
                is Resource.Success -> {
                    result.data?.let {
                        _state.value = HomeWeatherState(city = it)
                    }
                }
                is Resource.Error -> {
                    _state.value = HomeWeatherState(error = result.message ?: "Error inesperado")
                }
            }
        }.launchIn(viewModelScope)
    }

}
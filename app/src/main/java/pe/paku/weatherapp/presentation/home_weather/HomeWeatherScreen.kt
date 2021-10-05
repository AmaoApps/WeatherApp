package pe.paku.weatherapp.presentation.home_weather

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun HomeWeatherScreen(
    navController: NavController,
    viewModel: HomeWeatherViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Titulo Ciudad")
                }
            )
        },
        content = {
            getBodyCityWeather(navController = navController, state = state, viewModel = viewModel)
        }
    )
}

@Composable
fun getBodyCityWeather(
    navController: NavController,
    state: HomeWeatherState,
    viewModel: HomeWeatherViewModel
){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp))
        {
            if(state.city.id!=0){
                Text(
                    text = "${state.city.name} - ${state.city.id}"
                )
            }
            if(state.isLoading){
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            if(state.error.isNotBlank()){
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}

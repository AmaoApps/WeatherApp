package pe.paku.weatherapp.presentation.home_weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pe.paku.weatherapp.R
import pe.paku.weatherapp.commons.Constants
import pe.paku.weatherapp.presentation.home_weather.components.HeaderCityWeather

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
                    Text(text = Constants.EMPTY_STRING)
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_icon_search),
                            contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = null
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_icon_radar),
                            contentDescription = null
                        )
                    }
                },
                backgroundColor = Color.Transparent,
                elevation = 0.dp
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
            .offset(y = -56.dp)
    ) {
        if(state.city.id!=0){
            Box(
                modifier = Modifier
                    .weight(.4f)
                    .fillMaxSize()
            ) {
                HeaderCityWeather(city = state.city)
            }
            Box(
                modifier = Modifier
                    .weight(.6f)
                    .fillMaxSize()
            ) {
                Text(
                    text = "detalles City",
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center)
            }
        }
        if(state.isLoading){
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(8.dp))
            {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
        if(state.error.isNotBlank()){
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(8.dp))
            {
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

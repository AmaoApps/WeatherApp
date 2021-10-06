package pe.paku.weatherapp.presentation.home_weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import pe.paku.weatherapp.R
import pe.paku.weatherapp.commons.Constants
import pe.paku.weatherapp.presentation.home_weather.components.DateWeekWeatherItem
import pe.paku.weatherapp.presentation.home_weather.components.HeaderCityWeather
import pe.paku.weatherapp.presentation.home_weather.components.HoursWeeklyWeatherBody

@ExperimentalPagerApi
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

@ExperimentalPagerApi
@Composable
fun getBodyCityWeather(
    navController: NavController,
    state: HomeWeatherState,
    viewModel: HomeWeatherViewModel
){
    val pagerState = rememberPagerState()
    var daySelected : Int  by remember { mutableStateOf(0) }
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
                HorizontalPager(
                    count = 2,
                    state = pagerState
                ) {
                    HeaderCityWeather(city = state.city)
                }
                HorizontalPagerIndicator(
                    pagerState = pagerState, modifier = Modifier
                        .padding(top = 64.dp)
                        .align(Alignment.TopCenter)
                )
            }
            if(state.isLoading){
                Box(modifier = Modifier
                    .weight(.6f)
                    .fillMaxWidth()
                    .padding(8.dp))
                {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            } else {
                Box(
                    modifier = Modifier
                        .weight(.6f)
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            for ((index, daysCity) in state.detailCity.days.withIndex()){
                                DateWeekWeatherItem(
                                    dateCityWeek = daysCity,
                                    daySelected = daySelected,
                                    onClick = {daySelected = index; println("Pulsaste $index")})
                            }
                        }
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(2.dp)
                        )
                        HoursWeeklyWeatherBody(state.detailCity, selectedDay = daySelected)
                    }
                }
            }
        }
        if(state.isLoading && state.city.id == 0){
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

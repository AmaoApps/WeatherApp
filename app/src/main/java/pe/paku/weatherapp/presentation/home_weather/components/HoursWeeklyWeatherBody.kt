package pe.paku.weatherapp.presentation.home_weather.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.paku.weatherapp.commons.Constants
import pe.paku.weatherapp.commons.getStringHourOfDay
import pe.paku.weatherapp.domain.model.CityDetailWeather
import pe.paku.weatherapp.domain.model.CityHourWeather

@Composable
fun HoursWeeklyWeatherBody(cityDetail: CityDetailWeather, selectedDay: Int){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        RowHourWeeklyWeather(isHeader = true)
        for (detailHour in cityDetail.days[selectedDay].hourly){
            RowHourWeeklyWeather(cityHour = detailHour, isHeader = false)
        }
    }
}

@Composable
fun RowHourWeeklyWeather(cityHour: CityHourWeather? = null, isHeader :Boolean = false){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(isHeader){
            Spacer(modifier = Modifier
                .height(24.dp)
                .weight(.16f))
            Box(modifier = Modifier
                .weight(.16f),
                contentAlignment = Alignment.Center
            ){
                Text( text = Constants.WeatherFeature.TIME, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Box(modifier = Modifier
                .weight(.16f),
                contentAlignment = Alignment.Center
            ){
                Text( text = Constants.WeatherFeature.TEMP, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Box(modifier = Modifier
                .weight(.16f),
                contentAlignment = Alignment.Center
            ){
                Text( text = Constants.WeatherFeature.CHANCE_RAIN, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Box(modifier = Modifier
                .weight(.16f),
                contentAlignment = Alignment.Center
            ){
                Text( text = Constants.WeatherFeature.WIND, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Box(modifier = Modifier
                .weight(.16f),
                contentAlignment = Alignment.Center
            ){
                Text( text = Constants.WeatherFeature.HUMIDITY, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        } else {
            cityHour?.let {
                Box(modifier = Modifier
                    .weight(.16f),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = painterResource(id = getIconWeatherByTypeWeather(cityHour.weatherType)),
                        contentDescription = null,
                        modifier = Modifier.padding(4.dp)
                    )
                }
                Box(modifier = Modifier
                    .weight(.16f),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = cityHour.hour.getStringHourOfDay(), fontSize = 18.sp)
                }
                Box(modifier = Modifier
                    .weight(.16f),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "${cityHour.temperatura}º", fontSize = 18.sp)
                }
                Box(modifier = Modifier
                    .weight(.16f),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "${cityHour.rainChance}%", fontSize = 18.sp)
                }
                Box(modifier = Modifier
                    .weight(.16f),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "${cityHour.windSpeed}", fontSize = 18.sp)
                }
                Box(modifier = Modifier
                    .weight(.16f),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "${cityHour.humidity}%", fontSize = 18.sp)
                }
            }
        }
    }
}
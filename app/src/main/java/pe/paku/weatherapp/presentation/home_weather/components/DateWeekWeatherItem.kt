package pe.paku.weatherapp.presentation.home_weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.paku.weatherapp.R
import pe.paku.weatherapp.commons.Constants
import pe.paku.weatherapp.domain.model.CityDayWeather

@Composable
fun DateWeekWeatherItem(dateCityWeek: CityDayWeather){
    Column(
        modifier = Modifier
            .padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = getNameDayByCityDay(dateCityWeek.dayOfWeek),
            fontSize = 16.sp,
            modifier = Modifier.padding(4.dp)
        )
        Image(
            painter = painterResource(id = getIconWeatherByTypeWeather(dateCityWeek.weatherType)),
            contentDescription = null,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = dateCityWeek.temperature.toString() + "º",
            fontSize = 12.sp,
            modifier = Modifier.padding(4.dp)
        )
    }
}

fun getNameDayByCityDay(idDay:Int) : String{
    when(idDay){
        0 -> return "Mon"
        1 -> return "Tue"
        2 -> return "Wed"
        3 -> return "Thu"
        4 -> return "Fri"
        5 -> return "Sat"
        6 -> return "Sun"
        else -> return ""
    }
}

fun getIconWeatherByTypeWeather(type:String): Int {
    when(type) {
        Constants.WeatherType.SUNNY -> return R.drawable.ic_icon_weather_active_ic_sunny_active
        Constants.WeatherType.CLOUDY -> return R.drawable.ic_icon_weather_active_ic_cloudy_active
        Constants.WeatherType.PARTY_CLOUDY -> return R.drawable.ic_icon_weather_active_ic_partly_cloudy_active
        Constants.WeatherType.SNOW_SLEET -> return R.drawable.ic_icon_weather_active_ic_snow_sleet_active
        Constants.WeatherType.HEAVY_RAIN -> return R.drawable.ic_icon_weather_active_ic_heavy_rain_active
        Constants.WeatherType.LIGHT_RAIN -> return R.drawable.ic_icon_weather_active_ic_light_rain_active
        else -> return R.drawable.ic_icon_rainfall
    }
}
package pe.paku.weatherapp.presentation.navigation

import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.paku.weatherapp.commons.Constants
import pe.paku.weatherapp.presentation.home_weather.HomeWeatherScreen
import pe.paku.weatherapp.presentation.image_weather.ImageWeatherScreen

@Composable
fun NavigationApp(){
    val navigation = rememberNavController()
    navigation.enableOnBackPressed(true)
    //val currentScreen by navigation.currentBackStackEntryAsState()

    NavHost(navController = navigation, startDestination = Constants.PathScreen.HOME_WEATHER){
        composable(route = Constants.PathScreen.HOME_WEATHER){
            HomeWeatherScreen(navController = navigation)
        }
        composable(route = Constants.PathScreen.IMAGE_WEATHER){
            ImageWeatherScreen(navController = navigation, imageCity = "IMG ciudad")
        }
    }

}
package pe.paku.weatherapp.presentation.image_weather

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ImageWeatherScreen(
    navController: NavController,
    imageCity: String
){
    Text(text = "Ciudad Imagen de -> $imageCity")
}
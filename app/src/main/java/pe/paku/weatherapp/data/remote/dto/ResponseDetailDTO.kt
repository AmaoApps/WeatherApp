package pe.paku.weatherapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ResponseDetailDTO(
    @SerializedName("city")
    val city: CityDTO,
    @SerializedName("weather")
    val weather: WeatherDTO
)
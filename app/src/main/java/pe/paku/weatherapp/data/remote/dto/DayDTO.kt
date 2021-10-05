package pe.paku.weatherapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class DayDTO(
    @SerializedName("dayOfTheWeek")
    val dayOfTheWeek: Int,
    @SerializedName("high")
    val high: Int,
    @SerializedName("hourlyWeather")
    val hourlyWeather: List<HourlyWeatherDTO>,
    @SerializedName("low")
    val low: Int,
    @SerializedName("weatherType")
    val weatherType: String
)
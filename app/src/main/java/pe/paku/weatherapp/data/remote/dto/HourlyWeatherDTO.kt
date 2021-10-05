package pe.paku.weatherapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class HourlyWeatherDTO(
    @SerializedName("hour")
    val hour: Int,
    @SerializedName("humidity")
    val humidity: Double,
    @SerializedName("rainChance")
    val rainChance: Int,
    @SerializedName("temperature")
    val temperature: Int,
    @SerializedName("weatherType")
    val weatherType: String,
    @SerializedName("windSpeed")
    val windSpeed: Int
)
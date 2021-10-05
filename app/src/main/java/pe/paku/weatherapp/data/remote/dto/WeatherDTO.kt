package pe.paku.weatherapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class WeatherDTO(
    @SerializedName("days")
    val days: List<DayDTO>,
    @SerializedName("id")
    val id: Int
)
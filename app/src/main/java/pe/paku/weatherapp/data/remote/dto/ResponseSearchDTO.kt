package pe.paku.weatherapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ResponseSearchDTO(
    @SerializedName("cities")
    val cities: List<CityDTO>,
    @SerializedName("startIndex")
    val startIndex: Int,
    @SerializedName("totalCitiesFound")
    val totalCitiesFound: Int
)
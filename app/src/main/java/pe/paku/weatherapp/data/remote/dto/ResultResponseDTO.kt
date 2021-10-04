package pe.paku.weatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResultResponseDTO(

    @SerializedName("cities")
    val cities: List<CityWeatherDTO>,
    @SerializedName("totalCitiesFound")
    val totalCitiesFound: Int,
    @SerializedName("startIndex")
    val startIndex: Int

)

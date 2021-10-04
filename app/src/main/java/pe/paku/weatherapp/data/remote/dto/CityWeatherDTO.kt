package pe.paku.weatherapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CityWeatherDTO(
    @SerializedName("admin1 code")
    val admin1Code: String,
    @SerializedName("admin2 code")
    val admin2Code: Int,
    @SerializedName("admin3 code")
    val admin3Code: Any,
    @SerializedName("admin4 code")
    val admin4Code: String,
    @SerializedName("alternatenames")
    val alternatenames: String,
    @SerializedName("asciiname")
    val asciiname: String,
    @SerializedName("cc2")
    val cc2: String,
    @SerializedName("country code")
    val countryCode: String,
    @SerializedName("dem")
    val dem: Int,
    @SerializedName("elevation")
    val elevation: Int,
    @SerializedName("feature class")
    val featureClass: String,
    @SerializedName("feature code")
    val featureCode: String,
    @SerializedName("geonameid")
    val geonameid: Int,
    @SerializedName("imageURLs")
    val imageURLs: ImageURLs,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("modification date")
    val modificationDate: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("timezone")
    val timezone: String
)
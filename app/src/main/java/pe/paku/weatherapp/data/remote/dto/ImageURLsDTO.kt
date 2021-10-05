package pe.paku.weatherapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ImageURLsDTO(
    @SerializedName("androidImageURLs")
    val androidImageURLs: AndroidImageURLsDTO,
    @SerializedName("iOSImageURLs")
    val iOSImageURLs: IOSImageURLsDTO
)
package pe.paku.weatherapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ImageURLs(
    @SerializedName("androidImageURLs")
    val androidImageURLs: AndroidImageURLs,
    @SerializedName("iOSImageURLs")
    val iOSImageURLs: IOSImageURLs
)
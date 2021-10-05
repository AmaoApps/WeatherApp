package pe.paku.weatherapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class IOSImageURLsDTO(
    @SerializedName("imageURL")
    val imageURL: String
)
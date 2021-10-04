package pe.paku.weatherapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AndroidImageURLs(
    @SerializedName("hdpiImageURL")
    val hdpiImageURL: String,
    @SerializedName("mdpiImageURL")
    val mdpiImageURL: String,
    @SerializedName("xhdpiImageURL")
    val xhdpiImageURL: String
)
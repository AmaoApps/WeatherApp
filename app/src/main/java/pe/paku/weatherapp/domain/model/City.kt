package pe.paku.weatherapp.domain.model

data class City(
    val id: Int,
    val name: String,
    val countryCode: String,
    val date: String,
    val time: String,
    val timezone: String
)

package pe.paku.weatherapp.commons

import java.text.SimpleDateFormat
import java.util.*

fun Date.getStringDateByTimeZone(timezone : String) : String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    dateFormat.timeZone = TimeZone.getTimeZone(timezone)
    return dateFormat.format(this)
}


fun Date.getStringTimeByTimeZone(timezone : String) : String {
    val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    dateFormat.timeZone = TimeZone.getTimeZone(timezone)
    return dateFormat.format(this)
}
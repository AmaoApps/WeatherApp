package pe.paku.weatherapp.commons

import java.text.SimpleDateFormat
import java.util.*

fun Date.getStringDateByTimeZone(timezone : String) : String {
    val dateFormat = SimpleDateFormat("EEE yyyy-MM-dd", Locale.getDefault())
    dateFormat.timeZone = TimeZone.getTimeZone(timezone)
    return dateFormat.format(this)
}


fun Date.getStringTimeByTimeZone(timezone : String) : String {
    val dateFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
    dateFormat.timeZone = TimeZone.getTimeZone(timezone)
    return dateFormat.format(this)
}

fun Int.getStringHourOfDay() : String {
    when(this){
        0 -> return "12AM"
        1 -> return "${this}AM"
        2 -> return "${this}AM"
        3 -> return "${this}AM"
        4 -> return "${this}AM"
        5 -> return "${this}AM"
        6 -> return "${this}AM"
        7 -> return "${this}AM"
        8 -> return "${this}AM"
        9 -> return "${this}AM"
        10 -> return "${this}AM"
        11 -> return "${this}AM"
        12 -> return "${this}PM"
        13 -> return "${this-12}PM"
        14 -> return "${this-12}PM"
        15 -> return "${this-12}PM"
        16 -> return "${this-12}PM"
        17 -> return "${this-12}PM"
        18 -> return "${this-12}PM"
        19 -> return "${this-12}PM"
        20 -> return "${this-12}PM"
        21 -> return "${this-12}PM"
        22 -> return "${this-12}PM"
        23 -> return "${this-12}PM"
        else -> return Constants.EMPTY_STRING
    }
}
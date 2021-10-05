package pe.paku.weatherapp.domain.repository.converters

import pe.paku.weatherapp.commons.getStringDateByTimeZone
import pe.paku.weatherapp.commons.getStringTimeByTimeZone
import pe.paku.weatherapp.data.remote.dto.*
import pe.paku.weatherapp.domain.model.City
import pe.paku.weatherapp.domain.model.CityDayWeather
import pe.paku.weatherapp.domain.model.CityDetailWeather
import pe.paku.weatherapp.domain.model.CityHourWeather
import java.util.*

fun ResponseSearchDTO.toCity() : City? {
    if(totalCitiesFound==1){
        return City(
            id =cities[0].geonameid,
            name = cities[0].name,
            countryCode = cities[0].countryCode,
            date = Calendar.getInstance().time.getStringDateByTimeZone(cities[0].timezone),
            time = Calendar.getInstance().time.getStringTimeByTimeZone(cities[0].timezone),
            timezone = cities[0].timezone,
            image = cities[0].imageURLs.androidImageURLs.xhdpiImageURL
        )
    } else return null
}

fun CityDTO.toCity() : City {
    return City(
        id = geonameid,
        name = name,
        countryCode = countryCode,
        date = Calendar.getInstance().time.getStringDateByTimeZone(timezone),
        time = Calendar.getInstance().time.getStringTimeByTimeZone(timezone),
        timezone = timezone,
        image = imageURLs.androidImageURLs.xhdpiImageURL
    )
}

fun DayDTO.toCityDayWeather() : CityDayWeather {
    return CityDayWeather(
        dayOfWeek = dayOfTheWeek,
        hourly = hourlyWeather.map { it.toCityHourWeather() }
    )
}

fun HourlyWeatherDTO.toCityHourWeather() : CityHourWeather {
    return CityHourWeather(
        hour = hour,
        temperatura = temperature,
        weatherType = weatherType,
        rainChance = rainChance,
        humidity = humidity,
        windSpeed = windSpeed
    )
}


fun ResponseDetailDTO.toCityDetailWeather() : CityDetailWeather {
    return CityDetailWeather(
        city = city.toCity(),
        days = weather.days.map { it.toCityDayWeather() }
    )
}
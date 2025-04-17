package info.alirezaahmadi.weather_ui.data

import androidx.annotation.DrawableRes
import info.alirezaahmadi.weather_ui.R

data class WeatherItem(
    val cityName: String,
    val temperature: Double,
    val weatherCondition: String,
    val minTemp: Double,
    val maxTemp: Double,
    val hourlyForecast: List<HourlyWeather>,
    val weeklyForecast: List<WeeklyWeather>
) {
    companion object {
        val fakeWeather = WeatherItem(
            cityName = "Montreal",
            temperature = 19.0,
            weatherCondition = "Mostly Clear",
            minTemp = 18.0,
            maxTemp = 24.0,
            hourlyForecast = listOf(
                HourlyWeather("1 AM", 19.0, 30),
                HourlyWeather("Now", 19.0, 10),
                HourlyWeather("3 AM", 18.0, 20),
                HourlyWeather("4 AM", 18.0, 10),
                HourlyWeather("5 AM", 19.0, 5)
            ),
            weeklyForecast = listOf(
                WeeklyWeather("Monday", 22.0, 20),
                WeeklyWeather("Tuesday", 23.0, 40),
                WeeklyWeather("Now", 21.0, 80),
                WeeklyWeather("Thursday", 24.0, 0),
                WeeklyWeather("Friday", 22.0, 35),
                WeeklyWeather("Saturday", 23.0, 100),
                WeeklyWeather("Sunday", 25.0, 90),
            )
        )
    }
}

data class HourlyWeather(
    val hour: String,
    val temperature: Double,
    val precipitationChance: Int,
    @DrawableRes val iconRes: Int = R.drawable.cloud_rain,
)

data class WeeklyWeather(
    val day: String,
    val temperature: Double,
    val precipitationChance: Int,
    @DrawableRes val iconRes: Int = R.drawable.cloud_rain,
)


package info.alirezaahmadi.weather_ui.data

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
                HourlyWeather("12 AM", 19.0, 30),
                HourlyWeather("Now", 19.0, 10),
                HourlyWeather("2 AM", 18.0, 20),
                HourlyWeather("3 AM", 18.0, 10),
                HourlyWeather("4 AM", 19.0, 5)
            ),
            weeklyForecast = listOf(
                WeeklyWeather("Monday", 16.0, 22.0, "Cloudy"),
                WeeklyWeather("Tuesday", 17.0, 23.0, "Partly Cloudy"),
                WeeklyWeather("Now", 15.0, 21.0, "Rainy"),
                WeeklyWeather("Thursday", 18.0, 24.0, "Sunny"),
                WeeklyWeather("Friday", 16.0, 22.0, "Windy"),
                WeeklyWeather("Saturday", 17.0, 23.0, "Mostly Clear"),
                WeeklyWeather("Sunday", 18.0, 25.0, "Sunny")
            )
        )
    }
}

data class HourlyWeather(
    val hour: String,
    val temperature: Double,
    val precipitationChance: Int,
    val iconRes: Int= R.drawable.cloud_rain,
    )

data class WeeklyWeather(
    val day: String,
    val minTemp: Double,
    val maxTemp: Double,
    val weatherCondition: String
)


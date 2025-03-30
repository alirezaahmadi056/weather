package info.alirezaahmadi.weather_ui.data

import androidx.annotation.DrawableRes
import info.alirezaahmadi.weather_ui.R

data class City(
    val location: String,
    val temperature: Int,
    val highTemp: Int,
    val lowTemp: Int,
    val condition: String,
    @DrawableRes val imageRes: Int=R.drawable.cloud_rain
){
    companion object {
        val fakeCities = listOf(
            City("Montreal, Canada", 19, 24, 18, "Mid Rain"),
            City("New York, USA", 22, 27, 20, "Sunny"),
            City("London, UK", 16, 20, 14, "Cloudy"),
            City("Paris, France", 18, 22, 16, "Foggy"),
            City("Tokyo, Japan", 25, 30, 22, "Stormy"),
            City("Toronto, Canada", 15, 19, 10, "Windy"),
            City("Los Angeles, USA", 28, 32, 25, "Sunny"),
            City("Berlin, Germany", 14, 18, 11, "Cloudy"),
            City("Moscow, Russia", 10, 14, 6, "Snowy"),
            City("Beijing, China", 22, 26, 18, "Hazy")
        )
    }
}


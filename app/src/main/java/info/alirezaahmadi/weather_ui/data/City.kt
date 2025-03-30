package info.alirezaahmadi.weather_ui.data

import androidx.annotation.DrawableRes
import info.alirezaahmadi.weather_ui.R

data class City(
    val name: String,
    val temperature: Int,
    val highTemp: Int,
    val lowTemp: Int,
    val condition: String,
    @DrawableRes val imageRes: Int
){
    companion object {
        val fakeCities = listOf(
            City("Paris", 22, 26, 18, "Sunny", R.drawable.cloud_rain),
            City("New York", 18, 22, 15, "Cloudy", R.drawable.cloud_rain),
            City("Tokyo", 25, 30, 20, "Rainy", R.drawable.cloud_rain),
            City("Sydney", 20, 24, 17, "Windy", R.drawable.cloud_rain),
            City("London", 16, 20, 12, "Foggy", R.drawable.cloud_rain)
        )
    }
}


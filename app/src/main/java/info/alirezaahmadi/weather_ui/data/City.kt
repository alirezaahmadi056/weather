package info.alirezaahmadi.weather_ui.data

import androidx.annotation.DrawableRes
import info.alirezaahmadi.weather_ui.R

data class City(
    val location: String,
    val temperature: Int,
    val highTemp: Int,
    val lowTemp: Int,
    val condition: String,
    @DrawableRes val imageRes: Int
){
    companion object {
        val fakeCities = listOf(
            City("Montreal, Canada", 19, 24, 18, "Mid Rain",R.drawable.cloud_mid_rain),
            City("New York, USA", 22, 27, 20, "Fast Wind",R.drawable.cloud_fast_wind),
            City("London, UK", 16, 20, 14, "Cloudy",R.drawable.sun_cloud_angled_rain),
            City("Paris, France", 18, 22, 16, "Tornado",R.drawable.tornado),
            City("Tokyo, Japan", 25, 30, 22, "Fast Wind",R.drawable.cloud_fast_wind),
            City("Toronto, Canada", 15, 19, 10, "Mid Rain",R.drawable.cloud_mid_rain),
            City("Los Angeles, USA", 28, 32, 25, "Tornado",R.drawable.tornado),
            City("Berlin, Germany", 14, 18, 11, "Cloudy",R.drawable.sun_cloud_angled_rain),
            City("Moscow, Russia", 10, 14, 6, "Fast Wind",R.drawable.cloud_fast_wind),
        )
    }
}


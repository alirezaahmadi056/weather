package info.alirezaahmadi.weather_ui.ui.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import info.alirezaahmadi.weather_ui.R
import info.alirezaahmadi.weather_ui.data.WeatherItem
import kotlin.math.roundToInt

@Composable
fun MainScreen() {

    val weatherItem = remember {  WeatherItem.fakeWeather}
    ImageBackground {
        WeatherHeader(
            temperature = weatherItem.temperature.toInt(),
            cityName = weatherItem.cityName,
            weatherCondition = weatherItem.weatherCondition,
            maxTemp = weatherItem.maxTemp.roundToInt(),
            minTemp = weatherItem.maxTemp.roundToInt()
        )
        Image(
            painter = painterResource(R.drawable.house),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .aspectRatio(1f),
        )
        ForecastSection(weatherItem.hourlyForecast, weatherItem.weeklyForecast)
    }
}
package info.alirezaahmadi.weather_ui.ui.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import info.alirezaahmadi.weather_ui.R
import info.alirezaahmadi.weather_ui.data.WeatherItem
import info.alirezaahmadi.weather_ui.ui.screen.search.BottomSheetSearchCity
import kotlin.math.roundToInt
@Preview
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
                .padding(top = 60.dp),
            contentScale = ContentScale.Fit
        )
        ForecastSection(weatherItem.hourlyForecast, weatherItem.weeklyForecast)
    }
}
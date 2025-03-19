package info.alirezaahmadi.weather_ui.ui.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoxScope.WeatherHeader(
    cityName: String,
    temperature: Int,
    weatherCondition: String,
    minTemp: Int,
    maxTemp: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .statusBarsPadding()
            .align(Alignment.TopCenter)
            .fillMaxWidth()
    ) {
        Spacer(Modifier.height(20.dp))
        Text(
            text = cityName,
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
        Text(
            text = "$temperature°",
            fontSize = 70.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
        Text(
            text = weatherCondition,
            fontSize = 16.sp,
            color = Color.White
        )
        Text(
            text = "H:$maxTemp°  L:$minTemp°",
            fontSize = 14.sp,
            color = Color.White
        )
    }
}

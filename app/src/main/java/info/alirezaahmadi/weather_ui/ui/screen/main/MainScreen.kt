package info.alirezaahmadi.weather_ui.ui.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import info.alirezaahmadi.weather_ui.R

@Composable
fun MainScreen() {
    ImageBackground {

        Image(
            painter = painterResource(R.drawable.house),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .aspectRatio(1f),
        )
    }
}
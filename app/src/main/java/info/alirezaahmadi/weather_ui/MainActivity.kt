package info.alirezaahmadi.weather_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import info.alirezaahmadi.weather_ui.ui.screen.main.MainScreen
import info.alirezaahmadi.weather_ui.ui.theme.WeatherUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherUiTheme {
                MainScreen()
            }
        }
    }
}

package info.alirezaahmadi.weather_ui.ui.screen.main

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import info.alirezaahmadi.weather_ui.R
import info.alirezaahmadi.weather_ui.data.HourlyWeather
import info.alirezaahmadi.weather_ui.data.WeeklyWeather
import info.alirezaahmadi.weather_ui.ui.screen.search.BottomSheetSearchCity
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BoxScope.ForecastSection(
    hourlyWeatherDta: List<HourlyWeather>,
    weeklyWeatherData: List<WeeklyWeather>,
) {
    val tabs = listOf("Hourly Forecast", "Weekly Forecast")
    val pagerState = rememberPagerState { tabs.size }
    val coroutineScope = rememberCoroutineScope()
    var showSheetSearch by remember { mutableStateOf(false) }
    BottomSheetSearchCity(
        isShow = showSheetSearch,
        onDismiss = { showSheetSearch = false }
    )
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
            .background(
                Brush.radialGradient(
                    listOf(
                        Color(0xff2E335A),
                        Color(0xff1C1B33),
                    )
                )
            )
            .align(Alignment.BottomCenter)
            .fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp, bottom = 4.dp)
                .size(70.dp, 4.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.LightGray, RoundedCornerShape(20.dp)),
        )
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.Transparent,
            contentColor = Color.White,
            divider = {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color.LightGray.copy(0.7f)
                )
            },
            indicator = { tabPositions ->
                Box(
                    Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                        .height(4.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xff593c7a))
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(
                                page = index,
                                animationSpec = tween(600)
                            )
                        }
                    },
                    text = {
                        Text(
                            text = title,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (pagerState.currentPage == index) Color.White else Color.Gray
                        )
                    }
                )
            }
        }
        HorizontalPager(
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> {
                    HourlyForecastSection(hourlyWeatherDta)
                }

                1 -> {
                    WeeklyHourlyForecastSection(weeklyWeatherData)
                }

                else -> {
                    HourlyForecastSection(hourlyWeatherDta)
                }
            }
        }
        BottomForecastSection{showSheetSearch=true}
    }
}

@Composable
fun BottomForecastSection(
    showSheetSearch:()->Unit
) {
    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(R.drawable.bottom_f1),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(110.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(R.drawable.bottom_f2),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(115.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .padding(bottom = 6.dp)
                .clip(CircleShape)
                .background(Color.White, CircleShape)
                .clickable(onClick = showSheetSearch)
        ) {
            Icon(
                painter = painterResource(R.drawable.plus),
                contentDescription = "",
                tint = Color(0xff48319D),
                modifier = Modifier.padding(12.dp)
            )
        }
        Box(
            modifier = Modifier
                .padding(start = 25.dp)
                .align(Alignment.CenterStart),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.hover),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(45.dp)
            )
        }
        Box(
            modifier = Modifier
                .padding(end = 25.dp)
                .align(Alignment.CenterEnd)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.menu),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }


    }
}

@Composable
fun HourlyForecastSection(
    hourlyData: List<HourlyWeather>,
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = hourlyData, key = { it.hour }) { weather ->
            ForecastItem(
                icon = weather.iconRes,
                time = weather.hour,
                temp = weather.temperature.roundToInt(),
                precipitationChance = weather.precipitationChance
            )
        }
    }
}

@Composable
fun WeeklyHourlyForecastSection(
    weeklyData: List<WeeklyWeather>,
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = weeklyData, key = { it.day }) { weather ->
            ForecastItem(
                icon = weather.iconRes,
                time = weather.day,
                temp = weather.temperature.roundToInt(),
                precipitationChance = weather.precipitationChance
            )
        }

    }
}

@Composable
fun ForecastItem(
    time: String,
    icon: Int,
    temp: Int,
    precipitationChance: Int
) {
    val background by animateColorAsState(
        targetValue = if (time == "Now") Color(0xff48319D) else
            Color(0xFF4C4F69),
        label = ""
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(background, shape = RoundedCornerShape(30.dp))
            .padding(vertical = 10.dp, horizontal = 12.dp)
    ) {
        Text(
            text = if (time.take(1).isDigitsOnly()) time.take(4)
            else "${time.take(3)} ",
            fontSize = 16.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Weather Icon",
            modifier = Modifier
                .size(32.dp)
        )
        Text(
            text = if (precipitationChance > 0) "${precipitationChance}%" else "",
            fontSize = 12.sp,
            color = Color.Cyan
        )

        Text(
            text = "$temp°",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(vertical = 8.dp),
        )
    }
}

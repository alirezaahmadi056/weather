package info.alirezaahmadi.weather_ui.ui.screen.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.alirezaahmadi.weather_ui.R
import info.alirezaahmadi.weather_ui.data.City

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

@Composable
fun BottomSheetSearchCity(
    isShow: Boolean,
    onDismiss: () -> Unit
) {

    if (!isShow) return
    val cityList = remember { City.fakeCities }
    var query by remember { mutableStateOf("") }
    val filterCity = remember { mutableStateListOf<City>() }
    val sheetState = rememberModalBottomSheetState(true)
    LaunchedEffect(key1 = query) {
        filterCity.clear()
        filterCity.addAll(
            cityList.filter { it.location.contains(query, ignoreCase = true) }
        )
    }
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = Color(0xff2E335A),
        dragHandle = { WeatherDragHandel(onDismiss) }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            stickyHeader {
                SearchSection(
                    query = query,
                    onQueryChange = { query = it }
                )
            }
            items(items = filterCity, key = { it.location }) { city ->
                WeatherCard(city = city)
            }
            if (filterCity.isEmpty()) {
                item {
                    Text(
                        text = "No results found",
                        fontSize = 16.sp,
                        color = Color.White.copy(alpha = 0.8f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().padding(16.dp)
                    )
                }

            }
        }
    }
}

@Composable
private fun WeatherDragHandel(
    onBack: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBack
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = Color.White
                )
            }
            Spacer(Modifier.width(4.dp))
            Text(
                text = "Weather",
                color = Color.White,
                fontSize = 22.sp
            )
        }

        IconButton(
            onClick = {}
        ) {
            Icon(
                painter = painterResource(R.drawable.more),
                contentDescription = "",
                tint = Color.White
            )
        }

    }
}


@Composable
fun WeatherCard(
    city: City
) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(25.dp))
            .drawCustomShapeWithDashedBorder()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Spacer(Modifier.height(15.dp))
            Text(
                text = "${city.temperature}°",
                fontSize = 48.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "H:${city.highTemp}°  L:${city.lowTemp}°",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.7f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = city.location,
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                text = city.condition,
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.8f)
            )
        }

        Image(
            painter = painterResource(city.imageRes),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(150.dp)
        )

    }
}

fun Modifier.drawCustomShapeWithDashedBorder(): Modifier = this.then(
    Modifier.drawBehind {
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(size.width, 180f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        drawPath(
            path = path,
            brush = Brush.linearGradient(
                listOf(Color(0xFF48319D), Color(0xFF362A84)),
                start = Offset.Zero,
                end = Offset(size.width, size.height)
            ),
            style = Fill
        )
    }
)

@Composable
private fun SearchSection(
    query: String,
    onQueryChange: (String) -> Unit
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier
            .background(Color(0xff2E335A))
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color(0xFFB0AFC3)
            )
        },
        placeholder = {
            Text(
                text = "Search for a city or airport",
                color = Color(0xFFB0AFC3),
                fontSize = 16.sp
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF221C3B),
            unfocusedContainerColor = Color(0xFF221C3B),
            cursorColor = Color.White,
            focusedIndicatorColor = Color(0xff2E335A),
            unfocusedIndicatorColor = Color(0xff2E335A),
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.LightGray
        ),
        shape = RoundedCornerShape(15.dp),
        singleLine = true
    )
}

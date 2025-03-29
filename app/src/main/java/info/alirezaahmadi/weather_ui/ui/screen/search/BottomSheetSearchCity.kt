package info.alirezaahmadi.weather_ui.ui.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.alirezaahmadi.weather_ui.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun BottomSheetSearchCity(
    isShow: Boolean,
    onDismiss: () -> Unit
) {

    if (!isShow) return
    val sheetState = rememberModalBottomSheetState(true)
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = Color(0xff2E335A),
        dragHandle = { WeatherDragHandel(onDismiss) }
    ) {
       LazyColumn(
           modifier = Modifier.fillMaxSize()
       ) {
           items(12){
               WeatherCard(
                   temperature = 19,
                   highTemp = 24,
                   lowTemp = 18,
                   location = "Montreal, Canada",
                   condition = "Mid Rain"
               )
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
    temperature: Int,
    highTemp: Int,
    lowTemp: Int,
    location: String,
    condition: String
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
                text = "$temperature°",
                fontSize = 48.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "H:$highTemp°  L:$lowTemp°",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.7f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = location,
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                text = condition,
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.8f)
            )
        }

        Image(
            painter = painterResource(R.drawable.cloud_rain),
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

@Preview
@Composable
fun PreviewWeatherCard() {
    WeatherCard(
        temperature = 19,
        highTemp = 24,
        lowTemp = 18,
        location = "Montreal, Canada",
        condition = "Mid Rain"
    )
}

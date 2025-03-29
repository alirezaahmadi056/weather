package info.alirezaahmadi.weather_ui.ui.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
        Box(
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun WeatherDragHandel(
    onBack: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
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
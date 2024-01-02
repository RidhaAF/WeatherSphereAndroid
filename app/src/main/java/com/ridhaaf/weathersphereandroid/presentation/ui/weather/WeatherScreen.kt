package com.ridhaaf.weathersphereandroid.presentation.ui.weather

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ridhaaf.weathersphereandroid.R
import com.ridhaaf.weathersphereandroid.presentation.theme.poppinsFamily
import com.ridhaaf.weathersphereandroid.utils.UiEvent
import kotlinx.coroutines.flow.collectLatest
import kotlin.math.roundToInt

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel(),
    navController: NavController? = null,
    context: Context = LocalContext.current,
) {
    val state = viewModel.state.value
    val weather = state.weather
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        viewModel.getUserLocation(context)
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier.fillMaxSize(),
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .wrapContentSize(Alignment.Center),
            )
        } else {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                WeatherCity(weather.cityName)
                WeatherDescription(weather.weather.description)
                Spacer(modifier = Modifier.height(16.dp))
                WeatherIcon(weather.weather.icon)
                Spacer(modifier = Modifier.height(16.dp))
                WeatherTemperature(weather.temp)
            }
        }
    }
}

@Composable
fun WeatherCity(city: String) {
    Text(
        text = city,
        fontFamily = poppinsFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.Medium,
    )
}

@Composable
fun WeatherDescription(description: String) {
    Text(
        text = description,
        color = Color.Gray,
        fontFamily = poppinsFamily,
        fontSize = 18.sp,
    )
}

@SuppressLint("DiscouragedApi")
@Composable
fun WeatherIcon(icon: String, context: Context = LocalContext.current) {
    val resourceId = context.resources.getIdentifier(
        icon,
        "drawable",
        context.packageName,
    )

    if (resourceId != 0) {
        WeatherIconImage(resourceId)
    } else {
        WeatherIconImage(R.drawable.c03d)
    }
}

@Composable
fun WeatherIconImage(@DrawableRes id: Int) {
    val painter = painterResource(id)

    Image(
        painter = painter,
        contentDescription = "Weather Icon",
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
    )
}

@Composable
fun WeatherTemperature(temperature: Double) {
    val temp: Int = temperature.roundToInt()

    Text(
        text = "$temp°C",
        fontFamily = poppinsFamily,
        fontSize = 64.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Preview
@Composable
fun WeatherScreenPreview() {
    WeatherScreen()
}
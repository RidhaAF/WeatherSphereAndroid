package com.ridhaaf.wheatersphereandroid.presentation.ui.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ridhaaf.wheatersphereandroid.R
import com.ridhaaf.wheatersphereandroid.presentation.theme.poppinsFamily

@Composable
fun WeatherScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        WeatherCity()
        WeatherDescription()
        Spacer(modifier = Modifier.height(16.dp))
        WeatherIcon()
        Spacer(modifier = Modifier.height(16.dp))
        WeatherTemperature()
    }
}

@Composable
fun WeatherCity() {
    Text(
        text = "Bandung",
        fontFamily = poppinsFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.Medium,
    )
}

@Composable
fun WeatherDescription() {
    Text(
        text = "Light Rain",
        color = Color.Gray,
        fontFamily = poppinsFamily,
        fontSize = 18.sp,
    )
}

@Composable
fun WeatherIcon() {
    val painter = painterResource(R.drawable.c03d)

    Image(
        painter = painter,
        contentDescription = "Weather Icon",
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
    )
}

@Composable
fun WeatherTemperature() {
    Text(
        text = "26°C",
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
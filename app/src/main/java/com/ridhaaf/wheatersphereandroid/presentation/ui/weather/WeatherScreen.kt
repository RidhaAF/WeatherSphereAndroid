package com.ridhaaf.wheatersphereandroid.presentation.ui.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ridhaaf.wheatersphereandroid.R

@Composable
fun WeatherScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        WeatherCity()
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
        style = MaterialTheme.typography.bodyLarge,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
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
        style = MaterialTheme.typography.titleLarge,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Preview
@Composable
fun WeatherScreenPreview() {
    WeatherScreen()
}
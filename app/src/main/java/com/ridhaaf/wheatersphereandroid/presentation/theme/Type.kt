package com.ridhaaf.wheatersphereandroid.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ridhaaf.wheatersphereandroid.R

val poppinsFamily = FontFamily(
    Font(R.font.poppins_thin, FontWeight.W100),
    Font(R.font.poppins_thin_italic, FontWeight.W100, FontStyle.Italic),
    Font(R.font.poppins_extra_light, FontWeight.W200),
    Font(R.font.poppins_extra_light_italic, FontWeight.W200, FontStyle.Italic),
    Font(R.font.poppins_light, FontWeight.W300),
    Font(R.font.poppins_light_italic, FontWeight.W300, FontStyle.Italic),
    Font(R.font.poppins_regular, FontWeight.W400),
    Font(R.font.poppins_italic, FontWeight.W400, FontStyle.Italic),
    Font(R.font.poppins_medium, FontWeight.W500),
    Font(R.font.poppins_medium_italic, FontWeight.W500, FontStyle.Italic),
    Font(R.font.poppins_semi_bold, FontWeight.W600),
    Font(R.font.poppins_semi_bold_italic, FontWeight.W600, FontStyle.Italic),
    Font(R.font.poppins_bold, FontWeight.W700),
    Font(R.font.poppins_bold_italic, FontWeight.W700, FontStyle.Italic),
    Font(R.font.poppins_extra_bold, FontWeight.W800),
    Font(R.font.poppins_extra_bold_italic, FontWeight.W800, FontStyle.Italic),
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    bodySmall = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    titleSmall = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    ),
    labelLarge = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    labelMedium = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
)
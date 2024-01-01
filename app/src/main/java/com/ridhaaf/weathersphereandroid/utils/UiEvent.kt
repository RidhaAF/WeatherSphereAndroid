package com.ridhaaf.weathersphereandroid.utils

sealed class UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent()
}
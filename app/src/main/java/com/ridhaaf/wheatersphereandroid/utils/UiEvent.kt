package com.ridhaaf.wheatersphereandroid.utils

sealed class UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent()
}
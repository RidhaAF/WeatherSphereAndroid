package com.ridhaaf.weathersphereandroid.presentation.ui.weather

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ridhaaf.weathersphereandroid.domain.usecases.WeatherUseCase
import com.ridhaaf.weathersphereandroid.utils.Resource
import com.ridhaaf.weathersphereandroid.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val useCase: WeatherUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var lat = -6.914744
    private var lon = 107.609810

    init {
        getWeather()
    }

    fun getUserLocation(context: Context) {
        viewModelScope.launch {
            useCase.getUserLocation(context).collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let {
                            lat = it.first
                            lon = it.second
                        }
                        _state.value = _state.value.copy(isLoading = false)
                    }

                    is Resource.Error -> {
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                result.message ?: "An unknown error occurred"
                            )
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = true)
                    }
                }
            }
        }
    }

    private fun getWeather() {
        viewModelScope.launch {
            useCase.getWeather(lat, lon).collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = result.data?.let {
                            _state.value.copy(
                                weather = it,
                                isLoading = false,
                            )
                        }!!
                    }

                    is Resource.Error -> {
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                result.message ?: "An unknown error occurred"
                            )
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = true)
                    }
                }
            }
        }
    }
}
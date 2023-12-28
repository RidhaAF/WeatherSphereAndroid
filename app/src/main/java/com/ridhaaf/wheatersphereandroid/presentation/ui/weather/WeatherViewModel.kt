package com.ridhaaf.wheatersphereandroid.presentation.ui.weather

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ridhaaf.wheatersphereandroid.domain.usecases.WeatherUseCase
import com.ridhaaf.wheatersphereandroid.utils.Resource
import com.ridhaaf.wheatersphereandroid.utils.UiEvent
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

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            useCase.getWeather(-6.914744, 107.609810).collectLatest { result ->
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
                        _state.value = WeatherState(isLoading = true)
                    }
                }
            }
        }
    }
}
package com.bor96dev.hwflow

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bor96dev.hwflow.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    val countries = mutableStateListOf<String>()

    init {
        viewModelScope.launch {
            repository.getAllCountries().collect { country ->
                countries.add(country)
            }
        }
    }
}
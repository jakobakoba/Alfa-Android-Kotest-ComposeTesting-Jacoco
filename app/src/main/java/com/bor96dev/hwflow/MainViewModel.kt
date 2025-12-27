package com.bor96dev.hwflow

import androidx.lifecycle.ViewModel
import com.bor96dev.hwflow.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainViewModel(
    private val repository: Repository
) : ViewModel() {

}
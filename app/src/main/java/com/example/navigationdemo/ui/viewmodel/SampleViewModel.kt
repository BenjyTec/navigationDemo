package com.example.navigationdemo.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val DEMO_FLOW_KEY = "sampleFlow"

    private val _demoFlow = savedStateHandle.getStateFlow(DEMO_FLOW_KEY, 0)
    val demoFlow: StateFlow<Int> = _demoFlow

    fun writeValue(value: Int) {
        savedStateHandle[DEMO_FLOW_KEY] = value
    }

}
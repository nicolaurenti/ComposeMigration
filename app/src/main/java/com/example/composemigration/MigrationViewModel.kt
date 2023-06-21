package com.example.composemigration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MigrationViewModel @Inject constructor() : ViewModel() {

    private val mutableState: MutableStateFlow<MigrationState> = MutableStateFlow(MigrationState.IDLE)
    val state: StateFlow<MigrationState> = mutableState.asStateFlow()

    fun buttonClicked() = viewModelScope.launch {
        mutableState.value = MigrationState.DOING_SOMETHING
    }
}

enum class MigrationState {
    IDLE,
    DOING_SOMETHING,
}

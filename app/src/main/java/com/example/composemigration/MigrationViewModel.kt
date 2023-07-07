package com.example.composemigration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composemigration.model.MigrationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MigrationViewModel @Inject constructor() : ViewModel() {

    private val mutableListState: MutableStateFlow<List<MigrationModel>> =
        MutableStateFlow(listOf())
    val listState: StateFlow<List<MigrationModel>> = mutableListState.asStateFlow()

    fun buttonClicked() = viewModelScope.launch {
        mutableListState.value = testList
    }

    private val testList = listOf(
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
        MigrationModel(),
    )
}

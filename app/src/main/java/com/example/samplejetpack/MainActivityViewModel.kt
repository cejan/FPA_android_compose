package com.example.samplejetpack

import androidx.lifecycle.ViewModel
import com.example.samplejetpack.AppState.Navigation.Page
import com.example.samplejetpack.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _appState = MutableStateFlow(AppState.initial())
    val appState: StateFlow<AppState> = _appState.asStateFlow()

    fun selectPage(page: AppState.Navigation.Page) {
        _appState.update {
            return@update it.copy(
                navigation = it.navigation.copy(
                    selectedPage = page
                )
            )
        }
    }

}
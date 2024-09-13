package com.example.samplejetpack

import androidx.lifecycle.ViewModel
//import com.androidfactory.onequote.AppState.Navigation.Page
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainActivityViewModel : ViewModel() {

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
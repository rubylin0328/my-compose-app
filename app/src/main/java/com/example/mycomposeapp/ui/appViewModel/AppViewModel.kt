package com.example.mycomposeapp.ui.appViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {
    var currentPage by mutableStateOf("weather forecast")
        private set
}
package com.example.mycomposeapp.ui.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.example.mycomposeapp.ui.appViewModel.AppViewModel

@Composable
fun AppTopBar(appViewModel: AppViewModel) {
    TopAppBar(
        title = {
            Text(
                text = appViewModel.currentPage
            )
        }
    )
}
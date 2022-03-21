package com.example.mycomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycomposeapp.ui.appNavHost.AppNavHost
import com.example.mycomposeapp.ui.appViewModel.AppViewModel
import com.example.mycomposeapp.ui.components.AppTopBar
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val appViewModel = AppViewModel()

    MyComposeAppTheme {
        val systemUiController = rememberSystemUiController()

        systemUiController.setSystemBarsColor(color = MaterialTheme.colors.primaryVariant)

        Scaffold(
            topBar = {
                AppTopBar(appViewModel = appViewModel)
            }
        ) {
            AppNavHost()
        }
    }
}
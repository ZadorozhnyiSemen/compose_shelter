package com.example.androiddevchallenge

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.example.androiddevchallenge.navigation.LocalBackDispatcher
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@Composable
fun ShelterApp(backPressedDispatcher: OnBackPressedDispatcher) {

    CompositionLocalProvider(LocalBackDispatcher provides backPressedDispatcher) {
        ProvideWindowInsets {
            NavGraph()
        }
    }
}
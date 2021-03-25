/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.data.ScreenState
import com.example.androiddevchallenge.ui.screen.Home
import com.example.androiddevchallenge.ui.screen.Login
import com.example.androiddevchallenge.ui.screen.Welcome
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyTheme {
                ProvideWindowInsets {
                    Column(Modifier.navigationBarsPadding()) {
                        MyApp(isSystemInDarkTheme())
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp(isDarkTheme: Boolean) {
    val navController = rememberNavController()
    NavHost(navController = navController, ScreenState.Welcome) {
        composable(ScreenState.Welcome) { Welcome(isDarkTheme, navController) }
        composable(ScreenState.Login) { Login(isDarkTheme, navController) }
        composable(ScreenState.Home) { Home(isDarkTheme) }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        ProvideWindowInsets {
            MyApp(isSystemInDarkTheme())
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        ProvideWindowInsets {
            MyApp(isSystemInDarkTheme())
        }
    }
}

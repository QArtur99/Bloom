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
package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.data.ScreenState
import com.example.androiddevchallenge.ui.theme.shapes

@Composable
fun Welcome(isDarkTheme: Boolean, navController: NavController) {
    val backgroundRes = if (isDarkTheme) R.drawable.dark_welcome_bg else R.drawable.light_welcome_bg
    val illosRes =
        if (isDarkTheme) R.drawable.dark_welcome_illos else R.drawable.light_welcome_illos
    val logo = if (isDarkTheme) R.drawable.dark_logo else R.drawable.light_logo

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary),
    ) {
        Background(backgroundRes)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 144.dp, start = 88.dp, bottom = 48.dp),
                imageVector = ImageVector.vectorResource(id = illosRes),
                contentDescription = stringResource(R.string.welcome_illos),
                contentScale = ContentScale.FillBounds,
            )
            Image(
                painter = painterResource(id = logo),
                contentDescription = stringResource(id = R.string.app_name)
            )
            Text(
                modifier = Modifier.paddingFromBaseline(top = 32.dp, bottom = 40.dp),
                text = stringResource(R.string.welcome_subtitle),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.subtitle1,
            )
            Button(
                onClick = { /*TODO*/ },
                shape = shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary
                ),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = stringResource(R.string.welcome_btn_sign_up),
                    color = MaterialTheme.colors.onSecondary,
                    style = MaterialTheme.typography.button,
                )
            }
            Text(
                modifier = Modifier
                    .clickable { navController.navigate(route = ScreenState.Login) },
                text = stringResource(R.string.welcome_btn_log_in),
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.button,
            )
        }
    }
}

@Composable
private fun Background(backgroundRes: Int) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        imageVector = ImageVector.vectorResource(id = backgroundRes),
        contentDescription = "welcome background",
        contentScale = ContentScale.FillBounds,
    )
}

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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.data.ScreenState
import com.example.androiddevchallenge.ui.theme.shapes

@Composable
fun Login(isDarkTheme: Boolean, navController: NavController) {

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Title()
        EmailField(emailState)
        PasswordField(passwordState)
        Info()
        LogInButton(navController)
    }
}

@Composable
private fun Title() {
    Text(
        modifier = Modifier.paddingFromBaseline(top = 276.dp, bottom = 16.dp),
        text = stringResource(R.string.login_title),
        color = MaterialTheme.colors.onBackground,
        style = MaterialTheme.typography.h1,
    )
}

@Composable
private fun LogInButton(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = ScreenState.Home) },
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
            text = stringResource(R.string.login_btn_log_in),
            color = MaterialTheme.colors.onSecondary,
            style = MaterialTheme.typography.button,
        )
    }
}

@Composable
private fun Info() {
    val annotatedString = buildAnnotatedString {
        append(stringResource(R.string.login_info_p1))
        append(" ")
        pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
        pushStringAnnotation(tag = "URL", annotation = "terms")
        append(stringResource(R.string.login_info_p2))
        pop()
        pop()
        append(" ")
        append(stringResource(R.string.login_info_p3))
        append(" ")
        pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
        pushStringAnnotation(tag = "URL", annotation = "policy")
        append(stringResource(R.string.login_info_p4))
        pop()
        pop()
    }
    Text(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .paddingFromBaseline(top = 24.dp, bottom = 16.dp),
        text = annotatedString,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.onBackground,
        style = MaterialTheme.typography.body2,
    )
}

@Composable
private fun EmailField(emailState: MutableState<String>) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            .height(56.dp),
        value = emailState.value,
        onValueChange = { emailState.value = it },
        label = {
            Row {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = stringResource(R.string.login_email_hint),
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.body1,
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onBackground,
            backgroundColor = MaterialTheme.colors.background
        )
    )
}

@Composable
private fun PasswordField(emailState: MutableState<String>) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .height(56.dp),
        value = emailState.value,
        onValueChange = { emailState.value = it },
        label = {
            Row {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = stringResource(R.string.login_pass_hint),
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.body1,
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onBackground,
            backgroundColor = MaterialTheme.colors.background
        )
    )
}

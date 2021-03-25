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
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.data.themeList
import com.example.androiddevchallenge.ui.theme.Elevation

@Composable
fun Home(isDarkTheme: Boolean) {
    val searchState = remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomActionBar()
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(0.dp),
            horizontalAlignment = Alignment.Start
        ) {
            SearchField(searchState = searchState)
            ThemesTitle()
            ThemesList()
            GardenTitle()
        }
    }
}

@Composable
private fun ThemesTitle() {
    Row(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    ) {
        Text(
            modifier = Modifier.paddingFromBaseline(top = 32.dp, bottom = 16.dp),
            text = "Browse themes",
            textAlign = TextAlign.Start,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1,
        )
    }
}

@Composable
fun ThemesList() {
    Row(
        modifier = Modifier
            .height(136.dp)
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 8.dp)
    ) {
        for (item in themeList) {
            Card(
                modifier = Modifier.padding(end = 8.dp),
                shape = MaterialTheme.shapes.small
            ) {
                Column {
                    Image(
                        modifier = Modifier
                            .height(96.dp)
                            .width(136.dp),
                        painter = painterResource(item.res),
                        contentScale = ContentScale.Crop,
                        contentDescription = item.name
                    )
                    Row(
                        modifier = Modifier
                            .width(136.dp)
                            .height(40.dp)
                            .background(color = MaterialTheme.colors.background)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .align(Alignment.CenterVertically),
                            text = item.name,
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colors.onBackground,
                            style = MaterialTheme.typography.h2,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun GardenTitle() {
    Row(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    ) {
        Text(
            modifier = Modifier.paddingFromBaseline(top = 32.dp, bottom = 16.dp),
            text = "Design your home garden",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1,
        )
    }
}

@Composable
private fun SearchField(searchState: MutableState<String>) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 40.dp)
            .height(56.dp),
        value = searchState.value,
        onValueChange = { searchState.value = it },
        label = {
            Row {
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(18.dp)
                        .padding(end = 4.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_search_24),
                    contentDescription = "search",
                    tint = MaterialTheme.colors.onBackground
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "Search",
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
private fun BottomActionBar() {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onBackground,
        elevation = Elevation.bottom_navigation
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = {},
            icon = { SmallIcon(resId = R.drawable.ic_baseline_home_24) },
            label = { Text(stringResource(id = R.string.icon_home)) }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = { SmallIcon(resId = R.drawable.ic_baseline_favorite_border_24) },
            label = { Text(stringResource(id = R.string.icon_favorites)) }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = { SmallIcon(resId = R.drawable.ic_baseline_account_circle_24) },
            label = { Text(stringResource(id = R.string.icon_profile)) }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = { SmallIcon(resId = R.drawable.ic_baseline_shopping_cart_24) },
            label = { Text(stringResource(id = R.string.icon_cart)) }
        )
    }
}

@Composable
fun SmallIcon(resId: Int) {
    Icon(
        painter = painterResource(id = resId),
        contentDescription = "",
        modifier = Modifier.size(24.dp)
    )
}
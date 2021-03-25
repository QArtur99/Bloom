package com.example.androiddevchallenge.ui.data

import com.example.androiddevchallenge.R

data class Theme(val name: String, val res: Int)

val themeList = listOf(
    Theme("Desert chic", R.drawable.p1),
    Theme("Tiny terrariums", R.drawable.p2),
    Theme("Jungle vibes", R.drawable.p3),
    Theme("Easy care", R.drawable.p4),
    Theme("Statements", R.drawable.p5),
)
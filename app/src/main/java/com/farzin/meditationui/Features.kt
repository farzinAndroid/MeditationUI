package com.farzin.meditationui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Features(
    val title: String,
    @DrawableRes val drawableRes: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color,
)

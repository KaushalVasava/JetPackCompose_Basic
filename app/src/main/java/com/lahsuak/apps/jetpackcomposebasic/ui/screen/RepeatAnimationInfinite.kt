package com.lahsuak.apps.jetpackcomposebasic.ui.screen

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RepeatAnimationInfinite() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var isRound by remember {
            mutableStateOf(false)
        }
        val repeatable = rememberInfiniteTransition(label = "repeatable")
        val color by repeatable.animateColor(
            initialValue = Color.Green,
            targetValue = Color.Red,
            animationSpec =
            infiniteRepeatable(
                animation = tween(5000),
                repeatMode = RepeatMode.Reverse
            ), label = "color"
        )
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color)
        )
    }
}

package com.lahsuak.apps.jetpackcomposebasic.ui.screen

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp

@Composable
fun ImageBorderAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite")
    val rotationAnimation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing)), label = "rotate"
    )
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            imageVector = Icons.Default.ArrowForward, contentDescription = null,
            modifier = Modifier
                .drawBehind {
                    rotate(rotationAnimation.value) {
                        drawCircle(
                            Brush.linearGradient(
                                colors = listOf(
                                    Color.Blue, Color.Green, Color.Yellow, Color.Red, Color.Magenta
                                )
                            ),
                            style = Stroke(8f)
                        )
                    }
                }
                .size(60.dp)
                .padding(8.dp)
                .clip(CircleShape)
        )
    }
}

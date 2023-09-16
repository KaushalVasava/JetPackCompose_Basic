package com.lahsuak.apps.jetpackcomposebasic.ui.screen

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimateStateValue() {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        var isRound by remember {
            mutableStateOf(false)
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green,
                contentColor = Color.Black,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            ),
            onClick = { isRound = !isRound }) {
            Text("Toggle")
        }
        val transition = updateTransition(targetState = isRound, label = null)
        val borderRadius by transition.animateInt(transitionSpec = {
            tween(2000)
        }, label = "borderRadius") {
            if (it) 100
            else 0
        }
        val color by transition.animateColor(transitionSpec = {
            tween(2000)
        }, label = "color") {
            if (it)
                Color.Green
            else
                Color.Red
        }
//        val borderRadius by animateIntAsState(
//            targetValue = if (isRound) 40 else 20,
//            label = "animate",
//            animationSpec = spring(
//                dampingRatio = Spring.DampingRatioHighBouncy,
//                stiffness = Spring.StiffnessLow
//            )
//            //tween(delayMillis = 100, durationMillis = 3000)
//        )
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(borderRadius))
                .background(color)
        )
    }
}
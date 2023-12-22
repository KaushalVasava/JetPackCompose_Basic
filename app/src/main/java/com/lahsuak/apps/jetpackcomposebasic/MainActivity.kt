package com.lahsuak.apps.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.lahsuak.apps.jetpackcomposebasic.ui.theme.JetPackComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    IndianFlagScreen()
                }
            }
        }
    }
}

@Composable
fun IndianFlagScreen() {
    val constraints = ConstraintSet {
        val orangeBox = createRefFor("orangebox")
        val greenBox = createRefFor("greenbox")
        val circle = createRefFor("circle")

        constrain(orangeBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(circle.top)
            width = Dimension.fillToConstraints
            height = Dimension.value(260.dp)
        }
        constrain(circle) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(greenBox) {
            top.linkTo(circle.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(260.dp)
        }
        createVerticalChain(orangeBox, circle, greenBox, chainStyle = ChainStyle.SpreadInside)
    }
    ConstraintLayout(constraints, modifier = Modifier.background(Color.White).fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color(0xFFFB8C00))
                .layoutId("orangebox")
        )
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.Blue)
                .layoutId("circle")
        )
        Box(
            modifier = Modifier
                .background(Color(0xFF2EB734))
                .layoutId("greenbox")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeBasicTheme {
        IndianFlagScreen()
    }
}
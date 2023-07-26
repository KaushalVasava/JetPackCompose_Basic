package com.lahsuak.apps.jetpackcomposebasic

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.animateRect
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lahsuak.apps.jetpackcomposebasic.ui.theme.JetPackComposeBasicTheme

/**
 * Note: LazyColumn and LazyRow are equivalent to RecyclerView in Android Views.

 * To display a scrollable column we use a LazyColumn.
-> LazyColumn renders only the visible items on screen, allowing performance gains when rendering a big list.
 **/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBasicTheme(dynamicColor = false) {
                ImageBorderAnimation()
            }
        }
    }
}

@Composable
fun ImageBorderAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite")
    val rotationAnimation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing)), label = "rotate"
    )

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

@Composable
fun AnimateContent() {
    Column(Modifier.fillMaxSize()) {
        var isVisible by remember {
            mutableStateOf(false)
        }
        Button(
            colors = ButtonColors(
                containerColor = Color.Green,
                contentColor = Color.Black,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            ),
            onClick = { isVisible = !isVisible }) {
            Text("Toggle")
        }
        AnimatedContent(
            targetState = isVisible,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            label = "content",
            content = {
                if (it) {
                    Box(modifier = Modifier.background(Color.Green))
                } else {
                    Box(modifier = Modifier.background(Color.Red))
                }
            },
            transitionSpec = {
                slideInHorizontally {
                    if (isVisible) it else -it
                } togetherWith slideOutHorizontally {
                    if (isVisible) -it else it
                }
            }
        )
    }
}

@Composable
fun RepeatAnimationInfinite() {
    Column(Modifier.fillMaxSize()) {
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
        Button(
            colors = ButtonColors(
                containerColor = Color.Green,
                contentColor = Color.Black,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            ),
            onClick = { isRound = !isRound }) {
            Text("Toggle")
        }
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color)
        )
    }
}

@Composable
fun AnimateStateValue() {
    Column(Modifier.fillMaxSize()) {
        var isRound by remember {
            mutableStateOf(false)
        }
        Button(
            colors = ButtonColors(
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

@Composable
fun AnimateViewVisibility() {
    Column(Modifier.fillMaxSize()) {
        var isVisible by remember {
            mutableStateOf(false)
        }
        Button(
            colors = ButtonColors(
                containerColor = Color.Green,
                contentColor = Color.Black,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            ),
            onClick = { isVisible = !isVisible }) {
            Text("Toggle")
        }
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically() + fadeIn(),
            exit = slideOutVertically() + fadeOut(),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(modifier = Modifier.background(Color.Red))
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    /** PERSISTENT STATE
     * Instead of using remember you can use rememberSaveable.
    This will save each state surviving configuration changes (such as rotations) and process death.
     **/
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greetings()
        }
    }
}

@Composable
fun Greeting(name: String) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = "Greeting"
    )
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello,")
                Text(
                    text = name, style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }
            ElevatedButton(
                onClick = { expanded = !expanded }
            ) {
                Text(if (expanded) "Show less" else "Show more")
            }
        }
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "item $it" }
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

// add new on-boarding screen
@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    JetPackComposeBasicTheme(dynamicColor = false) {
        Greetings()
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreviewDark() {
    JetPackComposeBasicTheme(dynamicColor = false) {
        Greetings()
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    JetPackComposeBasicTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

@Preview
@Composable
fun MyAppPreview() {
    JetPackComposeBasicTheme {
        MyApp(Modifier.fillMaxSize())
    }
}
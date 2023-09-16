package com.lahsuak.apps.jetpackcomposebasic.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lahsuak.apps.jetpackcomposebasic.model.AnimationItem
import com.lahsuak.apps.jetpackcomposebasic.ui.navigation.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val animationsType = listOf(
        AnimationItem("Animate Content", NavigationItem.AnimateContent.route),
        AnimationItem("Animate State", NavigationItem.AnimateState.route),
        AnimationItem("Animate Visibility", NavigationItem.AnimateVisibility.route),
        AnimationItem("Infinite Animation", NavigationItem.InfiniteAnimation.route),
        AnimationItem("Image border animation", NavigationItem.ImageBorderAnimation.route),
    )
    LazyColumn {
        items(animationsType) {
            Card(
                onClick = {
                    navController.navigate(it.navigationRoute)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
            ) {
                Text(
                    it.name,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(24.dp)
                )
            }
        }
    }
}
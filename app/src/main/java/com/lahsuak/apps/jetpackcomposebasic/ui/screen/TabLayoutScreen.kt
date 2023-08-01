package com.lahsuak.apps.jetpackcomposebasic.ui.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.lahsuak.apps.jetpackcomposebasic.model.TabItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TabLayoutScreen() {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        tabs.size
    }
    val selectedIndex = animateIntAsState(
        targetValue = pagerState.currentPage, label = "selection",
    )
    val coroutineScope = rememberCoroutineScope()
    val backgroundColor by animateColorAsState(if (tabs[pagerState.currentPage] == tabs[0])
        Color.Yellow else if (tabs[pagerState.currentPage] == tabs[1]) Color.Red else Color.Green,
        label = "color"
    )
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Jetpack Compose TabLayout") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            TabRow(
                selectedTabIndex = selectedIndex.value,

            ) {
                tabs.forEachIndexed { index, item ->
                    Tab(
                        selected = index == pagerState.currentPage,
                        text = { Text(text = item.title) },
                        icon = { Icon(item.icon, "") },
                        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    )
                }
            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.background(backgroundColor)
            ) {
                tabs[pagerState.currentPage].screen()
            }
        }
    }

}


val tabs = listOf(
    TabItem(
        title = "Home",
        icon = Icons.Filled.Home,
        screen = { TabScreen("Home") }
    ),
    TabItem(
        title = "Favorite",
        icon = Icons.Filled.Favorite,
        screen = { TabScreen("Favorite") }
    ),
    TabItem(
        title = "Settings",
        icon = Icons.Filled.Settings,
        screen = { TabScreen(content = "Settings") }
    )
)
package com.lahsuak.apps.jetpackcomposebasic.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.lahsuak.apps.jetpackcomposebasic.ui.viewpager.Pager
import com.lahsuak.apps.jetpackcomposebasic.ui.viewpager.dataList

@ExperimentalPagerApi
@Composable
fun OnBoarding(modifier: Modifier) {
    val viewPagerState = rememberPagerState()
    Column(modifier = modifier.padding(8.dp)) {
        HorizontalPager(
            count = dataList.size,
            state = viewPagerState,
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
        ) { pageIndex ->
            Page(modifier = modifier, dataList[pageIndex])
        }
        HorizontalPagerIndicator(
            pagerState = viewPagerState,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            activeColor = MaterialTheme.colors.primary,
            inactiveColor = Color.LightGray
        )
        AnimatedVisibility(visible = viewPagerState.currentPage == 2, modifier = Modifier.align(Alignment.End)) {
            Button(onClick = { }) {
                Text(text = "Start now")
            }
        }
    }
}

@Composable
fun Page(
    modifier: Modifier,
    pager: Pager
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(120.dp),
            painter = painterResource(pager.image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Text(text = pager.description)
    }
}

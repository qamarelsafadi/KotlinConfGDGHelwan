package com.qamar.kotlinconfgdghelwan

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.qamar.kotlinconfgdghelwan.components.CustomTabIndicator
import com.qamar.kotlinconfgdghelwan.components.ItemPager
import com.qamar.kotlinconfgdghelwan.model.KotlinConf
import kotlinx.coroutines.launch

@Composable
fun App() {
    Scaffold(
        topBar = {
            TopAppBar {
                Text(
                    "KtoinConfi GDG Helwan",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) {

        HomeContent()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent() {
    val pagerState = rememberPagerState()
    val myList = KotlinConf.list
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomTabIndicator(tabPositions, pagerState)
    }
    val scope = rememberCoroutineScope()

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(25.dp))
        ScrollableTabRow(
            modifier = Modifier
                .padding(PaddingValues(start = 37.dp, top = 33.dp))
                .height(30.dp),
            selectedTabIndex = pagerState.currentPage,
            indicator = indicator,
            backgroundColor = Color.White,
            edgePadding = 0.dp,
            divider = {
                Divider(color = Color.Transparent)
            }
        ) {
            myList.forEachIndexed { index, kotlinConf ->
                TabItem(pagerState.currentPage == index, kotlinConf.title,
                    onClickTab = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    })
            }
        }

        ItemPager(pagerState, myList)
    }
}

@Composable
fun TabItem(
    isSelected: Boolean, product: String,
    onClickTab: () -> Unit
) {
    val color: Color by animateColorAsState(
        if (isSelected) Color.White else Color.Gray
    )
    Tab(
        modifier = Modifier.zIndex(6f)
            .clip(RoundedCornerShape(50)),
        text = {
            Text(
                text = product ?: "", color = color,
            )
        },
        selected = isSelected,
        onClick = onClickTab,
    )
}

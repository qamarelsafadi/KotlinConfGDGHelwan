package com.qamar.kotlinconfgdghelwan.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.qamar.kotlinconfgdghelwan.model.KotlinConf
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalFoundationApi::class, ExperimentalResourceApi::class)
@Composable
internal fun ItemPager(
    pagerState: PagerState,
    pages: List<KotlinConf>
) {
    HorizontalPager(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        pageCount = pages.size,
        state = pagerState,
    ) { page ->
        val currentKotlinConf = pages[page]
        val pageOffset = pagerState.calculateCurrentOffsetForPage(page)
        Card(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxSize()
                .requiredHeight(400.dp)
                .padding(horizontal = 15.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(currentKotlinConf.image), "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .graphicsLayer {
                            // get a scale value between 1 and 1.75f, 1.75 will be when its resting,
                            // 1f is the smallest it'll be when not the focused page
                            val scale = lerp(1f, 1.75f, pageOffset)
                            // apply the scale equally to both X and Y, to not distort the image
                            scaleX = scale
                            scaleY = scale
                        },
                    contentScale = ContentScale.FillBounds
                )

                Spacer(Modifier.height(5.dp))
                Text(currentKotlinConf.description, fontSize = 12.sp)
            }
        }

    }
}

// extension method for current page offset
@OptIn(ExperimentalFoundationApi::class)
fun PagerState.calculateCurrentOffsetForPage(page: Int): Float {
    return (currentPage - page) + currentPageOffsetFraction
}

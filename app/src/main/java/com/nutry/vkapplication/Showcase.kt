package com.nutry.vkapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nutry.vkapplication.ui.theme.VKApplicationTheme


@Composable
fun Showcase(onAppClick: (Int) -> Unit) {
    val showcaseApps = apps
    val pages = showcaseApps.take(9).chunked(3)
    val pagerState = rememberPagerState { pages.size }
    Column(Modifier.fillMaxWidth()) {
        Text(
            "Витрина",
            modifier = Modifier.padding(vertical = 12.dp),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
        )
        HorizontalPager(state = pagerState) { page ->
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                pages[page].forEach { app -> AppItem(app, onClick = { onAppClick(app.id)}) }
            }
        }
    }
}

@Preview
@Composable
private fun Prevvv() {
    VKApplicationTheme() {
        Showcase({})
    }
}
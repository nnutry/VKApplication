package com.nutry.vkapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nutry.vkapplication.AppInfo
import com.nutry.vkapplication.AppItem
import com.nutry.vkapplication.Showcase
import com.nutry.vkapplication.Toolbar
import com.nutry.vkapplication.apps
import com.nutry.vkapplication.ui.theme.VKApplicationTheme

@Composable
fun AppCard(
    ItemId: Int,
    onShowcaseAppClick: (Int) -> Unit
) {
    // данные карточки
    val app : AppInfo = apps.get(ItemId)

    Column(Modifier.fillMaxSize()) {
        // тулбар
        Toolbar()

        // колонка
        Column(
            Modifier.fillMaxWidth().background(color = Color.White).padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // в ней ряд с названием и иконкой
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // иконка
                Icon(app.icon, contentDescription = app.name, modifier = Modifier.size(108.dp))
                Spacer(Modifier.width(12.dp))
                // название и категория
                Column {
                    Text(
                        app.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        app.category,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Text("Описание:", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
            Text(app.description, style = MaterialTheme.typography.bodyMedium)
            // витрина
            Showcase(onAppClick = onShowcaseAppClick)
        }
    }
}

@Preview
@Composable
private fun Prevvvv() {
    VKApplicationTheme() {
        AppCard(1, {})
    }
}
package com.nutry.vkapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nutry.vkapplication.ui.theme.VKApplicationTheme

data class AppInfo(
    val name: String,
    val description: String,
    val category: String,
    val icon: ImageVector
)

val apps = listOf(
    AppInfo("Почта", "Работа с электронной почтой", "Общение", Icons.Default.Email),
    AppInfo("Телефон", "Звонки и контакты", "Общение", Icons.Default.Phone),
    AppInfo("Карты", "Навигация и поиск мест", "Путешествия", Icons.Default.Place),
    AppInfo("Магазин", "Покупки онлайн", "Покупки", Icons.Default.ShoppingCart),
    AppInfo("Поиск", "Быстрый поиск в интернете", "Инструменты", Icons.Default.Search),
    AppInfo("Настройки", "Параметры устройства", "Система", Icons.Default.Settings),
    AppInfo("Избранное", "Любимые материалы", "Инструменты", Icons.Default.Favorite),
    AppInfo("Уведомления", "Центр оповещений", "Система", Icons.Default.Notifications),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKApplicationTheme {
                AppListScreen()
            }
        }
    }
}

@Composable
fun AppListScreen() {
    Column(Modifier.fillMaxSize()) {
        Toolbar()
        LazyColumn(
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(apps) { AppItem(it) }
        }
    }
}

@Composable
fun Toolbar() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .statusBarsPadding()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Иконка приложения",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(72.dp)
        )
    }
}

@Composable
fun AppItem(app: AppInfo) {
    Card(Modifier.fillMaxWidth()) {
        Row(
            Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(app.icon, contentDescription = app.name, modifier = Modifier.size(48.dp))
            Spacer(Modifier.width(12.dp))
            Column {
                Text(app.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(app.description, style = MaterialTheme.typography.bodyMedium)
                Text(app.category, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}
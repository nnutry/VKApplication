package com.nutry.vkapplication

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class AppInfo(
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    val icon: ImageVector
)

val apps = listOf(
    AppInfo(0, "Почта", "Работа с электронной почтой", "Общение", Icons.Default.Email),
    AppInfo(1, "Телефон", "Звонки и контакты", "Общение", Icons.Default.Phone),
    AppInfo(2, "Карты", "Навигация и поиск мест", "Путешествия", Icons.Default.Place),
    AppInfo(3, "Магазин", "Покупки онлайн", "Покупки", Icons.Default.ShoppingCart),
    AppInfo(4, "Поиск", "Быстрый поиск в интернете", "Инструменты", Icons.Default.Search),
    AppInfo(5, "Настройки", "Параметры устройства", "Система", Icons.Default.Settings),
    AppInfo(6, "Избранное", "Любимые материалы", "Инструменты", Icons.Default.Favorite),
    AppInfo(7, "Уведомления", "Центр оповещений", "Система", Icons.Default.Notifications),
    AppInfo(8, "Музыка", "Плеер и подборки", "Развлечения", Icons.Default.PlayArrow),
    AppInfo(9, "Уведомления", "Центр оповещений", "Система", Icons.Default.Notifications),
)
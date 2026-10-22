package com.nutry.vkapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nutry.vkapplication.ui.theme.VKApplicationTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            VKApplicationTheme {
                AppNavHost()
            }
        }
    }
}

@Composable
fun AppListScreen(onAppClick: (Int) -> Unit) {
    VKApplicationTheme() {
        Column(Modifier.fillMaxSize()) {
            Toolbar()
            LazyColumn(
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(apps) { app ->
                    // когда карточка нажимается, мы вызываем onAppClick и передаем id
                    AppItem(app = app, onClick = { onAppClick(app.id) })
                }

            }
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
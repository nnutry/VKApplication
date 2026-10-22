package com.nutry.vkapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AppItem(app: AppInfo, onClick: () -> Unit = {}) {
    Card(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
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
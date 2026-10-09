package com.nutry.vkapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri


const val EXTRA_TEXT = "extra_text"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainScreen() }
    }
}

@Composable
fun MainScreen() {
    var text by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, content =
    {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Текст или номер телефона") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(24.dp))

        // Явный Intent
        Button(onClick = {
            if (text.isBlank()) {
                Toast.makeText(context, "Поле пусто", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(context, SecondActivity::class.java)
                intent.putExtra(EXTRA_TEXT, text)
                context.startActivity(intent)
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Открыть вторую Activity")
        }

        // Неявный Intent
        Button(onClick = {
            if (isPhoneLike(text)) {
                context.startActivity(Intent(Intent.ACTION_DIAL, "tel:$text".toUri()))
            } else {
                Toast.makeText(context, "Введите номер телефона", Toast.LENGTH_SHORT).show()
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Позвонить другу")
        }

        // Системный Intent
        Button(onClick = {
            if (text.isBlank()) {
                Toast.makeText(context, "Поле пусто", Toast.LENGTH_SHORT).show()
            } else {
                val send = Intent(Intent.ACTION_SEND)
                send.type = "text/plain"
                send.putExtra(Intent.EXTRA_TEXT, text)
                context.startActivity(send)
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Поделиться текстом")
        }
        }
    )
}

// Валидация номера (все цифры или +()-, но не только эти символы)
private fun isPhoneLike(s: String) =
    s.any { it.isDigit() } && s.all { it.isDigit() || it in "+()- " }
package com.example.shivuassistant

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GeminiScreen() {
    var promptText by remember { mutableStateOf("") }
    var responseText by remember { mutableStateOf("Gemini Assistant Ready!") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Shivu Assistant - Gemini", fontSize = 20.sp, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = promptText,
            onValueChange = { promptText = it },
            label = { Text("Ask Gemini...") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { responseText = "Thinking for: $promptText..." },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Send to Gemini")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = responseText, fontSize = 16.sp)
    }
}

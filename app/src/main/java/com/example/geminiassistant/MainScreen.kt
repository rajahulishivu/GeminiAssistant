package com.example.geminiassistant

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {
    val items = listOf(
        BottomNavItem("Core", Icons.Default.Home),
        BottomNavItem("Trends", Icons.Default.TrendingUp),
        BottomNavItem("Creator", Icons.Default.VideoLibrary),
        BottomNavItem("AI Chat", Icons.Default.SmartToy),
        BottomNavItem("Instagram", Icons.Default.CameraAlt)
    )

    var selectedItemIndex by remember { mutableIntStateOf(2) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF0B1315),
                contentColor = Color.White
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = { selectedItemIndex = index },
                        icon = { Icon(item.icon, contentDescription = item.title) },
                        label = { Text(item.title) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF00E676),
                            selectedTextColor = Color(0xFF00E676),
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray,
                            indicatorColor = Color(0xFF132226)
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (selectedItemIndex) {
                0 -> PlaceholderScreen("Core Dashboard")
                1 -> PlaceholderScreen("Trends Screen")
                2 -> CreatorSpaceScreen()
                3 -> PlaceholderScreen("Gemini AI Chat")
                4 -> PlaceholderScreen("Instagram Manager")
            }
        }
    }
}

data class BottomNavItem(
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

@Composable
fun PlaceholderScreen(title: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = title, color = Color.White, fontSize = 20.sp)
    }
}

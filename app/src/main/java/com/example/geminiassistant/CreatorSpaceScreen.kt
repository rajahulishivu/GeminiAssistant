package com.example.geminiassistant

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreatorSpaceScreen() {
    val darkBackground = Color(0xFF0B1315)
    val cardBackground = Color(0xFF132226)
    val accentGreen = Color(0xFF00E676)
    val accentRed = Color(0xFFFF5252)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBackground)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "ಕ್ರಿಯೇಟರ್ ಸ್ಪೇಸ್",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "YouTube ಮುಖ್ಯ • ಎಡ-ಬಲಭಾಗಕ್ಕೆ ಸ್ವೈಪ್ ಮಾಡಿ",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PlatformTabButton("YouTube", Icons.Default.PlayArrow, true, accentGreen)
            PlatformTabButton("Instagram", Icons.Default.CameraAlt, false, Color.Gray)
            PlatformTabButton("Facebook", Icons.Default.ThumbUp, false, Color.Gray)
            PlatformTabButton("X", Icons.Default.Close, false, Color.Gray)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = cardBackground)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(accentGreen),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("M", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(text = "Mr Shivu_info", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Text(text = "ನಿಜವಾದ ಡೇಟಾ • ಈಗ ತಾನೇ ಅಪ್ಡೇಟ್", color = Color.Gray, fontSize = 11.sp)
                        }
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Refresh", tint = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    StatItem("46", "ಸಬ್ಸ್ಕ್ರೈಬರ್", accentGreen)
                    StatItem("40.9K", "ಒಟ್ಟು ವ್ಯೂಸ್", accentGreen)
                    StatItem("35", "ವಿಡಿಯೋ", accentGreen)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "🎬 ಇತ್ತೀಚಿನ ವಿಡಿಯೋಗಳು", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    VideoThumbnailCard("ಮಂತ್ರಾಲಯದ...", "6 views", modifier = Modifier.weight(1f))
                    VideoThumbnailCard("ವರ್ಷಕೋಮ...", "17 views", modifier = Modifier.weight(1f))
                    VideoThumbnailCard("ಹನುಮಂತನ ಮ...", "10 views", modifier = Modifier.weight(1f))
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = cardBackground)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.CheckCircle, contentDescription = "Guard", tint = accentRed)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Copyright Guard", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "ಅಪ್ಲೋಡ್ ಮಾಡುವ ಮೊದಲು ಪರಿಶೀಲಿಸಿ. ಇದು ಅಂದಾಜು ಮಾತ್ರ — ಅಂತಿಮ ಪರೀಕ್ಷೆ YouTube Studio ನ Checks.",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun PlatformTabButton(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector, isSelected: Boolean, tintColor: Color) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = if (isSelected) Color(0xFF1B3A36) else Color(0xFF132226),
        modifier = Modifier.height(40.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(icon, contentDescription = title, tint = tintColor, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = title, color = Color.White, fontSize = 14.sp)
        }
    }
}

@Composable
fun StatItem(value: String, label: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, color = color, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = label, color = Color.Gray, fontSize = 12.sp)
    }
}

@Composable
fun VideoThumbnailCard(title: String, views: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1C2D31))
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.DarkGray, RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                Box(modifier = Modifier.size(12.dp).clip(CircleShape).background(Color.Red))
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = title, color = Color.White, fontSize = 12.sp, maxLines = 1)
            Text(text = views, color = Color.Gray, fontSize = 10.sp)
        }
    }
}

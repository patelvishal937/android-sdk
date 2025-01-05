import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quest_package.R

@Composable
fun QLEarnedPointsView(
    isAchieved: Boolean,
    isActive: Boolean,
    descreptionText: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (isAchieved) {
            Image(
                painter = painterResource(id = R.drawable.streak_xp_completed),
                contentDescription = null,
                modifier = Modifier.size(43.dp)
            )
        }
        if (isActive) {
            Image(
                painter = painterResource(id = R.drawable.streak_xp_progress),
                contentDescription = null,
                modifier = Modifier.size(43.dp)
            )
        }
        if (!isActive && !isAchieved) {
            Image(
                painter = painterResource(id = R.drawable.streak_xp_pending),
                contentDescription = null,
                modifier = Modifier.size(43.dp)
            )
        }
        Text(descreptionText,
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = if (isActive) FontWeight.Medium else FontWeight.Light,
                color = if (isActive) Color(0xFF2C2C2C) else Color(0xFF6E6E6E)
            ),
        )
        Box(
            modifier = Modifier
                .size(4.dp)
                .background(
                    color = when {
                        isAchieved -> Color(0xFF939393)
                        isActive -> Color(0xFF0D3821)
                        else -> Color(0xFFEFEFEF)
                    },
                    shape = CircleShape
                )
        )
    }
}
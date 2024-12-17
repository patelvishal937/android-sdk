import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun qlProgressBar(timeRemaining: Int) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            text = "Time Remaining: $timeRemaining mins",
            fontSize = 14.sp,
            color = Color.Gray,

            )
        roundedProgressBar(progress = 48f, totalTime = 60f)
    }
}

@Composable
fun roundedProgressBar(progress: Float, totalTime: Float) {
    val progressPercentage = (progress / totalTime).coerceIn(0f, 1f)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .clip(RoundedCornerShape(16.dp)) // Apply rounded corners to the entire progress bar
            .background(Color(0xFFE0E0E0)) // Background color for the unfilled portion
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progressPercentage) // Width is based on progress
                .height(8.dp)
                .clip(RoundedCornerShape(16.dp)) // Apply rounded corners to the filled portion as well
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF81C784), Color(0xFFA5D6A7))
                    )
                )
        )
    }
}
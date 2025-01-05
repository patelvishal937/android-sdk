import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QlProgressBar(
    value: Double,
    total: Double,
    label: String
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .background(Color(0xffe6ebec), shape = RoundedCornerShape(8.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = "Time Remaining: $label",
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xff222222),
                modifier = Modifier
                    .padding(bottom = 5.dp)
            )
            RoundedProgressBar(progress = value, totalTime = total)
        }
    }
}



@Composable
fun RoundedProgressBar(progress: Double, totalTime: Double) {
    val progressPercentage = (progress / totalTime).coerceIn(0.0, 1.0).toFloat()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(5.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFFFFFFFF))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progressPercentage)
                .height(8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF083b42), Color(0xFF083b42))
                    )
                )
        )
    }
}
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun qlStreakComponent(
    modifier: Modifier = Modifier
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(20.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp)) // Background color and rounded corners for the card
            .padding(20.dp)
    ){
        Text(
            text = "2",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2F4F2F)
        )
        Text(
            text = "Streak days",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF2F4F2F)
        )
        Text(
            text = "This is the longest streak you’ve ever had",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp), // Adds space between items
            modifier = Modifier.fillMaxWidth()
                .padding()
                .padding(vertical = 20.dp)
        ) {
            items(listOf(5, 5, 5, 5, 10)) { points -> // Example list of points
                qlStreakPointIcon(earned = points == 5, points = points)
            }
        }
        qlProgressBar(timeRemaining = 48)
    }
}




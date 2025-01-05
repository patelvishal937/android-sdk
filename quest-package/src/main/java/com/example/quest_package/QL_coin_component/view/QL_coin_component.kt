
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.quest_package.R

@Composable
fun QLCoinComponent() {
    Row(
        modifier = Modifier
            .padding(4.dp) // Outer margin around the Row
            .background(
                color = Color.White,
                shape = RoundedCornerShape(50) // Circular shape
            )
            .border(1.dp, Color.Gray, RoundedCornerShape(50)) // Border around the background
            .padding(horizontal = 8.dp, vertical = 4.dp), // Inner padding inside the Row
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_xp),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "1",
        )
    }
}
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun qlStreakPointIcon(earned: Boolean, points: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,

            ) {
//            if (earned) {
//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data("https://cdn-icons-png.freepik.com/256/969/969088.png?semt=ais_hybrid")
//                        .crossfade(true)
//                        .build(),
//                    contentDescription = "Check Icon",
//                    modifier = Modifier.size(24.dp)
//                )
//            } else {
//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data("https://cdn-icons-png.flaticon.com/512/5957/5957125.png")
//                        .crossfade(true)
//                        .build(),
//                    contentDescription = "Coin Icon",
//                    modifier = Modifier.size(24.dp)
//
//                )
//            }
        }
        Text(
            text = if (earned) "Earned\n$points points" else "Earn\n$points points",
            fontSize = 12.sp,
            style = TextStyle(lineHeight = 16.sp),
            textAlign = TextAlign.Center,
            color = Color.Gray
        )
    }
}